package app.model.repository;

import app.model.TennisMatch;

import java.util.List;

public interface TennisMatchRepositoryInterface extends CRUDRepository<TennisMatch, Integer>  {
    public List<TennisMatch> findAllByRefereeId(Integer refereeId);
    List<TennisMatch> findAllByTennisPlayerId(Integer tennisPlayerId);

}

