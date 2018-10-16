/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.daos;

import duypn.classes.AbstractDAO;
import duypn.classes.IDaoRepository;
import duypn.conn.MyConnection;
import duypn.dtos.ContestDTO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duypnse63523
 */
public class ContestDAO extends AbstractDAO implements Serializable, IDaoRepository<ContestDTO> {

    public static ContestDAO Instance() {
        return new ContestDAO();
    }

    public List<ContestDTO> getAllContests() throws Exception {
        List<ContestDTO> contestGroup = null;
        try {
            String sql = "SELECT * FROM dbo.Contest";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            contestGroup = new ArrayList<>();
            while (rs.next()) {
                ContestDTO contest = getContest();
                contestGroup.add(contest);
            }
        } finally {
            CloseConnection();
        }
        return contestGroup;
    }

    public ContestDTO getContest(int contestId) throws Exception {
        ContestDTO contest = null;
        try {
            String sql = "SELECT * FROM dbo.Contest WHERE ContestId = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, contestId);
            rs = preStm.executeQuery();
            if (rs.next()) {
                contest = getContest();
            }
        } finally {
            CloseConnection();
        }
        return contest;
    }

    private ContestDTO getContest() throws SQLException {
        ContestDTO contest = new ContestDTO();
        contest.setAddress(rs.getString("ContestAddress"));
        contest.setStartTime(rs.getTimestamp("StartTime"));
        contest.setContestId(rs.getInt("ContestId"));
        contest.setContestName(rs.getString("ContestName"));
        contest.setDistrictId(rs.getInt("DistrictId"));
        contest.setEndTime(rs.getTimestamp("EndTime"));
        contest.setProvinceId(rs.getInt("ProvinceId"));
        contest.setTotalPrice(rs.getFloat("TotalPrice"));
        contest.setWardId(rs.getInt("WardId"));
        contest.setStatus(rs.getString("Status"));
        contest.setDescription(rs.getString("Description"));
        return contest;
    }

    public boolean create(ContestDTO info) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO dbo.Contest (ContestName, StartTime, EndTime, ProvinceId, DistrictId, WardId, ContestAddress, TotalPrice, Status, Description) VALUES (?,?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, info.getContestName());
            preStm.setTimestamp(2, info.getStartTime());
            preStm.setTimestamp(3, info.getEndTime());
            preStm.setInt(4, info.getProvinceId());
            preStm.setInt(5, info.getDistrictId());
            preStm.setInt(6, info.getWardId());
            preStm.setString(7, info.getAddress());
            preStm.setFloat(8, info.getTotalPrice());
            preStm.setString(9, info.getStatus());
            preStm.setString(10, info.getDescription());
            check = preStm.executeUpdate() > 0;
        } finally {
            CloseConnection();
        }
        return check;
    }

    public boolean update(ContestDTO contest) throws Exception {
        boolean result = false;
        try {
            String sql = "Update dbo.Contest SET ContestName = ?, StartTime = ?, EndTime = ?, ProvinceId = ?, DistrictId = ?, ContestAddress = ? " +
                    ", TotalPrice = ?, Status = ? ,Description = ? Where ContestId = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, contest.getContestName());
            preStm.setTimestamp(2, contest.getStartTime());
            preStm.setTimestamp(3, contest.getEndTime());
            preStm.setInt(4, contest.getProvinceId());
            preStm.setInt(5, contest.getDistrictId());
            preStm.setString(6, contest.getAddress());
            preStm.setFloat(7, contest.getTotalPrice());
            preStm.setString(8, contest.getStatus());
            preStm.setString(9, contest.getDescription());
            preStm.setInt(10, contest.getContestId());
            result = preStm.executeUpdate() > 0;
        } finally {
            CloseConnection();
        }
        return result;
    }

    public boolean delete(int contestId) throws Exception {
        boolean result = false;
        try {
            String sql = "DELETE FROM dbo.Contest WHERE ContestId = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, contestId);
            result = preStm.executeUpdate() > 0;
        } finally {
            CloseConnection();
        }
        return result;
    }


}
