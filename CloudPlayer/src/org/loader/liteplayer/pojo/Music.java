package org.loader.liteplayer.pojo;

/**
 * 2017年8月23日于四川
 * 参考网络开源播放器开发
 */
public class Music {
	// id title singer data time image
	private int id; // 音乐id
	private String title; // 音乐标题
	private String uri; // 音乐路径
	private int length; // 长度
	private String image; // icon
	private String artist; // 艺术家
	private long playTime;
	private long mp3InfoId;
	private int isLove;
	private String album;
	private long albumId;
	private long duration;
	private long size;
	private String url;
	private int isMusic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Object getDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAlbumId() {
		// TODO Auto-generated method stub
		return null;
	}
    public long getPlayTime() {
        return playTime;
    }
    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }
    public long getMp3InfoId() {
        return mp3InfoId;
    }

    public void setMp3InfoId(long mp3InfoId) {
        this.mp3InfoId = mp3InfoId;
    }
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public int getIsMusic() {
        return isMusic;
    }

    public void setIsMusic(int isMusic) {
        this.isMusic = isMusic;
    }
    public int getIsLove() {
        return isLove;
    }

    public void setIsLove(int isLove) {
        this.isLove = isLove;
    }
    public String toString() {
        return "Mp3Info{" +
                "id=" + id +
                ", mp3InfoId=" + mp3InfoId +
                ", playTime=" + playTime +
                ", isLove=" + isLove +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", albumId=" + albumId +
                ", duration=" + duration +
                ", size=" + size +
                ", url='" + url + '\'' +
                ", isMusic=" + isMusic +
                '}';
    }

}
