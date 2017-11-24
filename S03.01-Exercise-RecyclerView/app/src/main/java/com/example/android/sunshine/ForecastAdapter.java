package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    //  Add a class file called ForecastAdapter
    // Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

    // Create a private string array called mWeatherData
    private String[] mWeatherData;

    // Create the default constructor (we will pass in parameters in a later lesson)
    public ForecastAdapter() {
    }


    // Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // Extend RecyclerView.ViewHolder

    // Override onCreateViewHolder
    // Within onCreateViewHolder, inflate the list item xml into a view
    // Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.forecast_list_item, parent, false);
        return new ForecastAdapterViewHolder(view);
    }

    // Override onBindViewHolder
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weather = mWeatherData[position];

        // Set the text of the TextView to the weather for this list item's position
        holder.mWeatherTextView.setText(weather);
    }

    // (29) Override getItemCount
    // (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

    @Override
    public int getItemCount() {
        return mWeatherData != null ? mWeatherData.length : 0;
    }

    // (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // (32) After you save mWeatherData, call notifyDataSetChanged
    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        // Create a public final TextView variable called mWeatherTextView
        private final TextView mWeatherTextView;

        // Create a constructor for this class that accepts a View as a parameter
        // Call super(view) within the constructor for ForecastAdapterViewHolder
        // Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            this.mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }

    }


}
