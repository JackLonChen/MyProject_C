package org.loader.liteplayer.adapter;

import java.util.ArrayList;

import org.loader.liteplayer.R;
import org.loader.liteplayer.application.App;
import org.loader.liteplayer.pojo.Music;
import org.loader.liteplayer.utils.ImageTools;
import org.loader.liteplayer.utils.MusicIconLoader;
import org.loader.liteplayer.utils.MusicUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 2017年8月23日于四川
 * 参考网络开源播放器开发
 */
public class MusicListAdapter extends BaseAdapter {
	private int mPlayingPosition;
	private Context ctx;
	private ArrayList<Music> mp3Infos;

	public void setPlayingPosition(int position) {
		mPlayingPosition = position;
	}
	
	public int getPlayingPosition() {
		return mPlayingPosition;
	}
    public MusicListAdapter(Context ctx, ArrayList<Music> mp3Infos){
        this.ctx = ctx;
        this.mp3Infos = mp3Infos;
        //System.out.println("MyMusicListAdapter.java #0 : ctx = " + ctx + ",mp3Infos = " + mp3Infos.size());
    }

    public ArrayList<Music> getMp3Infos() {
        System.out.println("public ArrayList<Mp3Info> getMp3Infos() {");
        return mp3Infos;
    }

    public void setMp3Infos(ArrayList<Music> mp3Infos) {
        System.out.println("public void setMp3Infos(ArrayList<Mp3Info> mp3Infos) {");
        this.mp3Infos = mp3Infos;
    }
	
	@Override
	public int getCount() {
		return MusicUtils.sMusicList.size();
	}

	@Override
	public Object getItem(int position) {
		return MusicUtils.sMusicList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder ;
		
		if(convertView == null) {
			convertView = View.inflate(App.sContext, R.layout.music_list_item, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.tv_music_list_title);
			holder.artist = (TextView) convertView.findViewById(R.id.tv_music_list_artist);
			holder.icon = (ImageView) convertView.findViewById(R.id.music_list_icon);
			holder.mark = convertView.findViewById(R.id.music_list_selected);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(mPlayingPosition == position) {
			holder.mark.setVisibility(View.VISIBLE);
		}else {
			holder.mark.setVisibility(View.INVISIBLE);
		}
		
		Bitmap icon = MusicIconLoader.getInstance()
				.load(MusicUtils.sMusicList.get(position).getImage());
		holder.icon.setImageBitmap(icon == null ? 
				ImageTools.scaleBitmap(R.drawable.ic_launcher) : ImageTools.scaleBitmap(icon));
		
		holder.title.setText(MusicUtils.sMusicList.get(position).getTitle());
		holder.artist.setText(MusicUtils.sMusicList.get(position).getArtist());
		
		return convertView;
	}
	
	static class ViewHolder {
		ImageView icon;
		TextView title;
		TextView artist;
		View mark;
	}

	public static String formatTime(long music_duration) {
		// TODO Auto-generated method stub
		return null;
	}
}
