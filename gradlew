<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="8dp"
    android:divider="@android:color/transparent"
    android:elevation="8dp"
    android:clipChildren="false"
    android:clipToPadding="false"
    app:cardElevation="10dp"
    app:cardPreventCornerOverlap="false">

    <LinearLayout
        android:clipToPadding="false"
        android:clipChildren="false"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <ImageView
            android:id="@+id/imageItem"
            android:layout_width="154dp"
            android:layout_height="118dp"
            android:layout_marginLeft="8dp"
            android:layout_marginTop="2dp"
            android:src="@mipmap/ic_launcher" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <TextView
                android:id="@+id/tvTitle"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginStart="8dp"
                android:layout_marginLeft="8dp"
                android:layout_marginTop="8dp"
                android:fontFamily="sans-serif"
                android:text="Title"
                android:textColor="@color/colorAccent"
                android:textSize="17dp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/tvDescription"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="8dp"
                android:layout_marginLeft="8dp"
                android:layout_marginTop="8dp"
                android:text="Tất cả các thông tin mà"
                android:textSize="14dp" />

            <!--            <TextView-->
            <!--                android:id="@+id/tvPubDate"-->
            <!--                android:layout_width="wrap_content"-->
            <!--                android:layout_height="wrap_content"-->
            <!--                android:layout_marginStart="8dp"-->
            <!--                android:layout_marginLeft="8dp"-->
            <!--                android:layout_marginTop="8dp"-->
            <!--                android:text="TextView"-->
            <!--                android:textSize="15dp" />-->


        </LinearLayout>
    </LinearLayout>

</androidx.cardview.widget.CardView>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      