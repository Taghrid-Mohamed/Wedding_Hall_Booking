package service_MA;

import dao_MA.HallDAO_MA;
import model_MA.Hall_MA;

import java.sql.SQLException;
import java.util.List;

public class HallService_MA {

    private HallDAO_MA hallDAO = new HallDAO_MA();

    public void addHall(Hall_MA hall) throws SQLException {
        hallDAO.insertHall(hall);
    }

    public void updateHall(Hall_MA hall) throws SQLException {
        hallDAO.updateHall(hall);
    }

    public void deleteHall(int id) throws SQLException {
        hallDAO.deleteHall(id);
    }

    public List<Hall_MA> getAllHalls() throws SQLException {
        return hallDAO.getAllHalls();
    }
}
