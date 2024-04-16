package app.model.repository;

import app.model.Referee;
import app.model.TennisMatch;
import app.model.User;

import java.util.List;

public interface RefereeRepositoryInterface extends CRUDRepository<Referee, Integer>  {
    Referee findRefereeByAssociatedUser(User user);
    List<TennisMatch> findAllTennisMatchesByReferee(Referee referee);
}