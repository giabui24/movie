package com.example.movie;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;
import  io.reactivex.observables.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.movie.apdapter.BannerMoviePagerAdapter;
import com.example.movie.apdapter.MainRecycleAdapter;
import com.example.movie.model.AllCategory;
import com.example.movie.model.CategoryItemList;
import com.example.movie.model.MovieBanner;
import com.example.movie.retrofit.RetrofitClient;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    BannerMoviePagerAdapter bannerMoviePagerAdapter;
    TabLayout indicator_tab, categorytab;
    ViewPager bannermovieviewPager;
    List<MovieBanner> homeBannerMovieList;
    List<MovieBanner> TVBannerMovieList;
    List<MovieBanner> movieBannerMovieList;
    List<MovieBanner> kidBannerMovieList;
    MainRecycleAdapter mainRecycleAdapter;
    RecyclerView mainRecycle;
    List<AllCategory> allCategoryList1;
    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;
    Timer sliderTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        indicator_tab = (TabLayout) findViewById(R.id.tab_indicator);
        categorytab = findViewById(R.id.tablayout);
        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout = findViewById(R.id.appbar);


        homeBannerMovieList = new ArrayList<>();
//        homeBannerMovieList.add(new MovieBanner(1, "",
//                "https://cdn.collider.com/wp-content/uploads/2010/06/inception_movie_poster_banner_04.jpg", ""));

        TVBannerMovieList = new ArrayList<>();
//        TVBannerMovieList.add(new MovieBanner(1, "Revolution", "https://www.google.com/imgres?imgurl=https%3A%2F%2Fi0.wp.com%2Ffilm-book.com%2Fwp-content%2Fuploads%2F2013%2F09%2Frevolution-tv-show-banner-01-350x164.jpg%3Fresize%3D350%252C164%26ssl%3D1&imgrefurl=https%3A%2F%2Ffilm-book.com%2Frevolution-season-2-tv-show-poster-trailers-behind-the-scenes-video%2F&tbnid=Af_I5jNYbAyXTM&vet=12ahUKEwjB2PuS47DsAhXjM7cAHTeuAWkQMygFegUIARC1AQ..i&docid=eJ822krnmxOesM&w=350&h=164&q=tvshow%20banner&ved=2ahUKEwjB2PuS47DsAhXjM7cAHTeuAWkQMygFegUIARC1AQ", ""));
//
        movieBannerMovieList = new ArrayList<>();

        kidBannerMovieList = new ArrayList<>();

        //run
        getBannerData();
        //
        getAllMovieData(1);

//        Category tab changing
        categorytab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaulstate();
                        setBannerMoviePagerAdapter(TVBannerMovieList);
                        return;
                    case 2:
                        setScrollDefaulstate();
                        setBannerMoviePagerAdapter(movieBannerMovieList);
                        return;
                    case 3:
                        setScrollDefaulstate();
                        setBannerMoviePagerAdapter(kidBannerMovieList);
                        return;
                    default:
                        setScrollDefaulstate();
                        setBannerMoviePagerAdapter(homeBannerMovieList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });


        allCategoryList1 = new ArrayList<>();


    }


    public void setBannerMoviePagerAdapter(List<MovieBanner> bannerMovieList) {
        bannermovieviewPager = findViewById(R.id.banner_ViewPager);
        bannerMoviePagerAdapter = new BannerMoviePagerAdapter(this, bannerMovieList);
        bannermovieviewPager.setAdapter(bannerMoviePagerAdapter);
        indicator_tab.setupWithViewPager(bannermovieviewPager);
        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        indicator_tab.setupWithViewPager(bannermovieviewPager, true);

    }

    class AutoSlider extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannermovieviewPager.getCurrentItem() < homeBannerMovieList.size() - 1) {
                        bannermovieviewPager.setCurrentItem(bannermovieviewPager.getCurrentItem() + 1);
                    } else {
                        bannermovieviewPager.setCurrentItem(0);
                    }
                }

            });


        }
    }

    public void setMainRecycle(List<AllCategory> allCategoryList) {
        mainRecycle = findViewById(R.id.main_recycleview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);

        mainRecycle.setLayoutManager(layoutManager);
        mainRecycleAdapter = new MainRecycleAdapter(this, allCategoryList);
        mainRecycle.setAdapter(mainRecycleAdapter);
    }

    private void setScrollDefaulstate() {
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0, 0);
        appBarLayout.setExpanded(true);
    }

    private void getBannerData() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RetrofitClient.getRetrofitClient()
                .getAllBanners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<MovieBanner>>() {

                    @Override
                    public void onNext(List<MovieBanner> movieBanners) {
                        for (int i = 0; i < movieBanners.size(); i++) {
                            if (movieBanners.get(i).getCategoryId().toString().equals("1")) {
                                homeBannerMovieList.add(movieBanners.get(i));

                            } else if (movieBanners.get(i).getCategoryId().toString().equals("2")) {
                                TVBannerMovieList.add(movieBanners.get(i));
                            } else if (movieBanners.get(i).getCategoryId().toString().equals("3")) {
                                movieBannerMovieList.add(movieBanners.get(i));
                            } else if (movieBanners.get(i).getCategoryId().toString().equals("4")) {
                                kidBannerMovieList.add(movieBanners.get(i));
                            }

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {
                        setBannerMoviePagerAdapter(homeBannerMovieList);
                    }
                }));

    }

    private void getAllMovieData(int CategoryId) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getALLCategoryMovie
                (CategoryId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<List<AllCategory>>() {


            @Override
            public void onNext(List<AllCategory> allCategoryList) {
                setMainRecycle(allCategoryList);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("bannerData", "" + e);
            }

            @Override
            public void onComplete() {

            }
        }));
    }
    }
