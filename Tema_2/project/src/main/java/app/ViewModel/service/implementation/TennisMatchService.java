package app.ViewModel.service.implementation;

import app.model.Referee;
import app.model.TennisMatch;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.model.repository.RefereeRepositoryInterface;
import app.model.repository.TennisMatchRepositoryInterface;
import app.ViewModel.single_point_access.RepositorySinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.util.List;
import java.util.Random;

public class TennisMatchService implements TennisMatchServiceInterface {
    private TennisMatchRepositoryInterface tennisMatchRepository = RepositorySinglePointAccess.getTennisMatchRepository();
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    private RefereeRepositoryInterface refereeRepository = RepositorySinglePointAccess.getRefereeRepository();
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    @Override
    public TennisMatch save(TennisMatch tennisMatch) {
        Referee referee = tennisMatch.getReferee();
        TennisMatch tennisMatch1 = tennisMatchRepository.save(tennisMatch);
        refereeService.addTennisMatch(referee, tennisMatch);
        tennisPlayerService.addTennisMatch(tennisMatch.getTennisPlayer1(), tennisMatch);
        tennisPlayerService.addTennisMatch(tennisMatch.getTennisPlayer2(), tennisMatch);
        return tennisMatch1;
    }

    @Override
    public TennisMatch update(TennisMatch tennisMatch) {
        return tennisMatchRepository.update(tennisMatch);
    }

    @Override
    public List<TennisMatch> findAll() {
        return tennisMatchRepository.findAll();
    }

    @Override
    public TennisMatch findById(Integer id) {
        return tennisMatchRepository.findById(id);
    }

    @Override
    public boolean delete(TennisMatch tennisMatch) {
        return tennisMatchRepository.delete(tennisMatch);
    }
    @Override
    public List<TennisMatch> findAllByRefereeId(Integer refereeId) {
        return tennisMatchRepository.findAllByRefereeId(refereeId);
    }

    @Override
    public List<TennisMatch> findAllByTennisPlayerId(Integer tennisPlayerId) {
        return tennisMatchRepository.findAllByTennisPlayerId(tennisPlayerId);
    }

    @Override
    public void changeReferees(List<TennisMatch> tennisMatches)
    {
        Random random = new Random();
        List<Referee> referees = refereeRepository.findAll();
        if(referees.size() > 0)
        {
            for (TennisMatch tennisMatch: tennisMatches) {
                int index = random.nextInt(referees.size());
                tennisMatch.setReferee(referees.get(index));
                tennisMatchRepository.update(tennisMatch);
            }
        }
        else
        {
            for (TennisMatch tennisMatch: tennisMatches) {
                tennisMatchRepository.delete(tennisMatch);
            }
        }
    }
}
