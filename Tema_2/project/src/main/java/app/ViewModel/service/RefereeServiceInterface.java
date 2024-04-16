package app.ViewModel.service;

import app.model.Referee;
import app.model.TennisMatch;

import java.util.List;

public interface RefereeServiceInterface {
    Referee save(Referee referee);

    Referee update(Referee referee);

    List<Referee> findAll();

    Referee findById(Integer id);

    boolean delete(Referee referee);
    void addTennisMatch(Referee referee, TennisMatch tennisMatch);
    List<TennisMatch> getAllTennisMatchesOfReferee(Referee referee);
}
