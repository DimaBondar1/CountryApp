package com.test_project.countryapp.views.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test_project.countryapp.R;
import com.test_project.countryapp.util.CallBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    @NonNull
    List<String> cities;

    @NonNull
    CallBack<String> call;

    public CityAdapter(@NonNull List<String> countries, @NonNull CallBack<String> call) {
        this.cities = countries;
        this.call = call;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_city, parent, false);

        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.CityViewHolder holder, int position) {
        String name = cities.get(position);

        if(name.isEmpty()){
            return;
        }

        holder.bind(name, position);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CityViewHolder  extends RecyclerView.ViewHolder{

        @BindView(R.id.city)
        CardView cardView;

        @BindView(R.id.city_name)
        TextView textView;

        private int position;

        public CityViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.city)
        public void cardListener(){
            call.back(cities.get(position));
        }

        void bind(String city, int index){
            textView.setText(city);
            position = index;
        }
    }
}
