package app.ViewModel.service;

import app.model.TennisMatch;

import java.util.List;

public interface TennisMatchServiceInterface {
    TennisMatch save(TennisMatch tennisMatch);

    TennisMatch update(TennisMatch tennisMatch);

    List<TennisMatch> findAll();

    TennisMatch findById(Integer id);

    boolean delete(TennisMatch tennisMatch);
    public List<TennisMatch> findAllByRefereeId(Integer id);
    void changeReferees(List<TennisMatch> tennisMatches);
    List<TennisMatch> findAllByTennisPlayerId(Integer tennisPlayerId);
}
