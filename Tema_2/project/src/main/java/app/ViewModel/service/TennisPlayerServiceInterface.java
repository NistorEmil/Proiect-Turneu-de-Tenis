package app.ViewModel.service;

import app.model.TennisMatch;
import app.model.TennisPlayer;

import java.util.List;

public interface TennisPlayerServiceInterface {
    TennisPlayer save(TennisPlayer tennisPlayer);

    TennisPlayer update(TennisPlayer tennisPlayer);

    List<TennisPlayer> findAll();

    TennisPlayer findById(Integer id);

    boolean delete(TennisPlayer tennisPlayer);
    void addTennisMatch(TennisPlayer tennisPlayer, TennisMatch tennisMatch);
}
