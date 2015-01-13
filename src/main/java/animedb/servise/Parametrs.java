package animedb.servise;

import java.sql.Date;
import java.util.Arrays;

public class Parametrs {

    private int type; //ТВ
    private String date; //1990 + 10
    private int[] genres;
    private int sortedType;
    private int page;

    public int getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public int[] getGenres() {
        return genres;
    }

    public int getSortedType() {
        return sortedType;
    }

    public int getPage() {
        return page;
    }

    public void setType(String type) {
        if (date != null && !type.equals(""))
            this.type = Integer.parseInt(type);
    }

    public void setDate(String date) {
        if (date != null && !date.equals(""))
            this.date = Integer.toString(Integer.valueOf(date) + 1990);
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
        if (date != null && !sortedType.equals(""))
            this.sortedType = Integer.parseInt(sortedType);
        else
            this.sortedType = 1;
    }

    public void setPage(String page) {
        if (date != null && !page.equals(""))
            this.page = Integer.parseInt(page);
    }

    @Override
    public String toString() {
        return "Parametrs{" +
                "type=" + type +
                ", date=" + date +
                ", genres=" + Arrays.toString(genres) +
                ", sortedType=" + sortedType +
                ", page=" + page +
                '}';
    }
}
