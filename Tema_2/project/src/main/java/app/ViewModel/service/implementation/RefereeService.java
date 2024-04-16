package app.ViewModel.service.implementation;

import app.model.Referee;
import app.model.TennisMatch;
import app.ViewModel.service.RefereeServiceInterface;
import app.model.repository.RefereeRepositoryInterface;
import app.ViewModel.single_point_access.RepositorySinglePointAccess;

import java.util.ArrayList;
import java.util.List;

public class RefereeService implements RefereeServiceInterface {
    private RefereeRepositoryInterface refereeRepository = RepositorySinglePointAccess.getRefereeRepository();

    @Override
    public Referee save(Referee referee) {
        return refereeRepository.save(referee);
    }

    @Override
    public Referee update(Referee referee) {
        return refereeRepository.update(referee);
    }

    @Override
    public List<Referee> findAll() {
        return refereeRepository.findAll();
    }

    @Override
    public Referee findById(Integer id) {
        return refereeRepository.findById(id);
    }

    @Override
    public boolean delete(Referee referee) {
        return refereeRepository.delete(referee);
    }
    @Override
    public List<TennisMatch> getAllTennisMatchesOfReferee(Referee referee) {
        return refereeRepository.findAllTennisMatchesByReferee(referee);
    }
        public void addTennisMatch(Referee referee, TennisMatch tennisMatch)
    {
        Referee referee1 = refereeRepository.findById(referee.getId());
        List<TennisMatch> tennisMatches = referee1.getTennisMatches();
        if (tennisMatches == null)
        {
            tennisMatches = new ArrayList<>();
            tennisMatches.add(tennisMatch);
        }
        else {
            tennisMatches.add(tennisMatch);
        }
        refereeRepository.update(referee1);
    }

}
