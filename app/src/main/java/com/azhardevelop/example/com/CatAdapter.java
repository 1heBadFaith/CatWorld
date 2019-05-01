package com.azhardevelop.example.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azhardevelop.example.com.model.ApiServiceCat;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatHolder> {

    Context context;
    LayoutInflater inflater;
    private List<ApiServiceCat> catList;
    String image_url = "https://api.thecatapi.com/images/";

    public CatAdapter(MenuActivity activity, List<ApiServiceCat> catList) {
        this.context = activity;
        this.catList = catList;
        inflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.item_kucing, parent, false);
        CatHolder holder = new CatHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder catHolder, int position) {
        catHolder.txtNama.setText(catList.get(position).getName());
        catHolder.txtOri.setText(catList.get(position).getOrigins());
        catHolder.txtDesc.setText(catList.get(position).getDescription());

        //Picasso
        Picasso
                .with(context)
                .load(image_url + catList.get(position).getImages())
                .transform(new RoundedCornersTransformation(8, 5))
                .placeholder(R.drawable.cat)
                .error(R.drawable.cat)
                .into(catHolder.imgCat);

    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public class CatHolder extends RecyclerView.ViewHolder {

        View catView;
        ImageView imgCat;
        TextView txtNama, txtOri, txtDesc;


        public CatHolder(@NonNull View itemView) {
            super(itemView);
            catView = itemView;
            txtNama = itemView.findViewById(R.id.namaKucing);
            txtOri = itemView.findViewById(R.id.originCat);
            txtDesc = itemView.findViewById(R.id.descCat);
            imgCat = itemView.findViewById(R.id.gambarCat);
        }
    }
}
