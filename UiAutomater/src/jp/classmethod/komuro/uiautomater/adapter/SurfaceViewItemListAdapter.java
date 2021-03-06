package jp.classmethod.komuro.uiautomater.adapter;

import java.util.List;

import jp.classmethod.komuro.uiautomater.R;
import jp.classmethod.komuro.uiautomater.dto.ItemDto;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SurfaceViewItemListAdapter extends ArrayAdapter<ItemDto> {
	
	private Context context;

	public SurfaceViewItemListAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		
		this.context = context;
	}

	public SurfaceViewItemListAdapter(Context context, int resource, int textViewResourceId) {
		super(context, resource, textViewResourceId);
		
		this.context = context;
	}

	public SurfaceViewItemListAdapter(Context context, int textViewResourceId,
			ItemDto[] objects) {
		super(context, textViewResourceId, objects);
		
		this.context = context;
	}

	public SurfaceViewItemListAdapter(Context context, int textViewResourceId,
			List<ItemDto> objects) {
		super(context, textViewResourceId, objects);
		
		this.context = context;
	}

	public SurfaceViewItemListAdapter(Context context, int resource,
			int textViewResourceId, ItemDto[] objects) {
		super(context, resource, textViewResourceId, objects);
		
		this.context = context;
	}

	public SurfaceViewItemListAdapter(Context context, int resource,
			int textViewResourceId, List<ItemDto> objects) {
		super(context, resource, textViewResourceId, objects);
		
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SurfaceViewHolder holder;
		
		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listview_item_layout2, parent, false);
			
			holder = new SurfaceViewHolder();
			holder.labelText = (TextView) convertView.findViewById(R.id.label_text);
			holder.surfaceView = (SurfaceView) convertView.findViewById(R.id.surface_view);
			
			convertView.setTag(holder);
		} else {
			holder = (SurfaceViewHolder) convertView.getTag();
		}
		
		final ItemDto item = getItem(position);
		
		if(item != null) {
			holder.labelText.setText(item.getLabel());
			holder.surfaceView.getHolder().addCallback(holder);
		}
		
		return convertView;
	}
}
