package com.example.pierreabichacra.tester;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Pierre Abi Chacra on 3/12/2018.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.CustomViewHolder>{
    Context context;
    ArrayList<Hero> heroes;

public HeroAdapter(Context context, ArrayList<Hero> heroes) {
}

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_row,null,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
    Hero hero = heroes.get(position);
        Picasso.with(context).load(hero.getImgurl()).into(holder.imageView);
        holder.textView.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public CustomViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            textView = (TextView) view.findViewById(R.id.textView);
        }
    }


    }

