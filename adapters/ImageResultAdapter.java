package wszolek.lauren.imagesearch.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import wszolek.lauren.imagesearch.R;
import wszolek.lauren.imagesearch.models.ImageResult;

public class ImageResultAdapter extends ArrayAdapter<ImageResult> {
    private static class ViewHolder {
        ImageView ivImage;
    }

    public ImageResultAdapter(Context context, ArrayList<ImageResult> images) {
        super(context, R.layout.item_image_result, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageResult imageResult = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_image_result, parent, false);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // clear out image from last time
        viewHolder.ivImage.setImageResource(0);
        // remotely download image in background
        Picasso.with(getContext())
                .load(imageResult.thumbUrl)
// implement this in a min
//                .placeholder(R.drawable.placeholder)
                .into(viewHolder.ivImage);

        return convertView;
    }
}
