package wszolek.lauren.imagesearch.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import wszolek.lauren.imagesearch.R;
import wszolek.lauren.imagesearch.models.ImageResult;

public class ImageHolder extends RecyclerView.ViewHolder {
    public ImageView ivImage;
    public ImageResult mImageResult;

    public ImageHolder(View itemView) {
        super(itemView);
        // set onclick listeners here
        ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
    }

    //@Override
    // public void onClick(View view) {
    //}
}

