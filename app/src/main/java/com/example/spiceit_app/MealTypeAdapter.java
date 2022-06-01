package com.example.spiceit_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MealTypeAdapter extends ArrayAdapter<MealCourse> {

    public MealTypeAdapter(Context context, ArrayList<MealCourse> mealCourseArrayList) {
        super(context, R.layout.meal_item, mealCourseArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MealCourse mealCourse = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.meal_item,parent,false);
        }

            ImageView imageView = convertView.findViewById(R.id.mealimage);
        TextView course = convertView.findViewById(R.id.mealtype);

        imageView.setImageResource(mealCourse.imageId);
        course.setText(mealCourse.mealCourse);



        return super.getView(position, convertView, parent);
    }
}
