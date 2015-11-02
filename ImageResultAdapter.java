package wszolek.lauren.imagesearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class ImageResultAdapter extends ArrayAdapter<ImageResult> {
    private static class ViewHolder {
        GridView gvResults;
    }

    public ImageResultAdapter(Context context, ArrayList<ImageResult> aBooks) {
        super(context, 0, aBooks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //nothing yet
    }
}
