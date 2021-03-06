package br.com.rmso.filmesfamosos.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Raquel on 12/06/2018.
 */
@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie ORDER BY title")
    LiveData<List<Movie>> loadAllMovie();

    @Insert
    void insertMovie(Movie movie);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);

    @Query("SELECT * FROM movie WHERE id = :id")
    LiveData<Movie> loadMovieById(int id);

    @Query("SELECT * FROM movie WHERE id = :id")
    List<Movie> loadMovieByUId(int id);
}
