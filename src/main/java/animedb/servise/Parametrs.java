package animedb.servise;

import java.sql.Date;

public class Parametrs {

    private int type; //ТВ
    private Date date; //1990 + 10
    private int[] genres;
    private int sortedType;
    private int page;

    public void setType(String type) {
        if (type != null)
            this.type = Integer.parseInt(type);
    }

    public void setDate(String date) {
        if (date != null)
            this.date = Date.valueOf("01-01-" + Integer.toString((Integer.parseInt(date) + 1990)));
    }

    public void setGenres(String[] genres) {
        if (genres != null) {
            this.genres = new int[genres.length];

            for (int i = 0; i < genres.length; i++) {
                this.genres[i] = Integer.parseInt(genres[i]);
            }
        }
    }

    public void setSortedType(String sortedType) {
        if (sortedType != null)
            this.sortedType = Integer.parseInt(sortedType);
    }

    public void setPage(String page) {
        if (page != null)
            this.page = Integer.parseInt(page);
    }
}
