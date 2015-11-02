package wszolek.lauren.imagesearch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import wszolek.lauren.imagesearch.R;
import wszolek.lauren.imagesearch.holders.ImageHolder;
import wszolek.lauren.imagesearch.models.ImageResult;

public class ImageResultAdapter extends RecyclerView.Adapter<ImageHolder> {
    private ArrayList<ImageResult> imageResults;
    private Context context;

    public ImageResultAdapter(Context context, ArrayList<ImageResult> imageResults) {
        this.imageResults = imageResults;
        this.context = context;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_result, null);
        ImageHolder imageHolder = new ImageHolder(layoutView);
        return imageHolder;
    }

    @Override
    public void onBindViewHolder(ImageHolder imageHolder, int position) {
        ImageResult imageResult = imageResults.get(position);
        Picasso.with(context)
                .load(imageResult.thumbUrl)
// implement this in a min
//                .placeholder(R.drawable.placeholder)
                .into(imageHolder.ivImage);
    }

    @Override
    public int getItemCount() {
        return this.imageResults.size();
    }

}
/*



        public void bindImageResult(ImageResult imageResult) {
            mImageResult = imageResult;
            Picasso.with(getContext())
                    .load(imageResult.thumbUrl)
// implement this in a min for the color placeholders
//                .placeholder(R.drawable.placeholder)
                    .into(ivImage);

        }
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
*/
