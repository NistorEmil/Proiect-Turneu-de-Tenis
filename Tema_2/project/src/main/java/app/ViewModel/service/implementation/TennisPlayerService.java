package app.ViewModel.service.implementation;

import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.model.repository.TennisPlayerRepositoryInterface;
import app.ViewModel.single_point_access.RepositorySinglePointAccess;

import java.util.ArrayList;
import java.util.List;

public class TennisPlayerService implements TennisPlayerServiceInterface {

    private TennisPlayerRepositoryInterface tennisPlayerRepository = RepositorySinglePointAccess.getTennisPlayerRepository();

    @Override
    public TennisPlayer save(TennisPlayer tennisPlayer) {
        return tennisPlayerRepository.save(tennisPlayer);
    }

    @Override
    public TennisPlayer update(TennisPlayer tennisPlayer) {
        return tennisPlayerRepository.update(tennisPlayer);
    }

    @Override
    public List<TennisPlayer> findAll() {
        return tennisPlayerRepository.findAll();
    }

    @Override
    public TennisPlayer findById(Integer id) {
        return tennisPlayerRepository.findById(id);
    }

    @Override
    public boolean delete(TennisPlayer tennisPlayer) {
        return tennisPlayerRepository.delete(tennisPlayer);
    }
    @Override
    public void addTennisMatch(TennisPlayer tennisPlayer, TennisMatch tennisMatch)
    {
        TennisPlayer tennisPlayer1 = tennisPlayerRepository.findById(tennisPlayer.getId());
        List<TennisMatch> tennisMatches = tennisPlayer1.getTennisMatches();
        if (tennisMatches == null)
        {
            tennisMatches = new ArrayList<>();
            tennisMatches.add(tennisMatch);
        }
        else {
            tennisMatches.add(tennisMatch);
        }
        tennisPlayerRepository.update(tennisPlayer);
    }
}
