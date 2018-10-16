package duypn.classes.converters;

import duypn.classes.parsers.IntegerParse;
import duypn.daos.DistrictDAO;
import duypn.daos.ProvinceDAO;
import duypn.daos.WardDAO;
import duypn.dtos.ContestDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DtoConverter {

    public static ContestDTO getContestDTO (HttpServletRequest request) throws Exception {
        ContestDTO contest = new ContestDTO();

        if(IntegerParse.tryParse(request.getParameter("ContestId")))
            contest.setContestId(Integer.parseInt(request.getParameter("ContestId")));
        contest.setAddress(request.getParameter("Address"));
        contest.setContestName(request.getParameter("ContestName"));
        contest.setEndTime(Timestamp.valueOf(LocalDateTime.parse(request.getParameter("EndTime"), DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
        contest.setStartTime(Timestamp.valueOf(LocalDateTime.parse(request.getParameter("StartTime"), DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
        contest.setStatus(request.getParameter("Status"));
        contest.setTotalPrice(Float.parseFloat(request.getParameter("TotalPrice")));
        contest.setDescription(request.getParameter("Description"));

        String ProvinceName = StringConverter.convert(request.getParameter("ProvinceName"));
        String DistrictName = StringConverter.convert(request.getParameter("DistrictName"));
        String WardName = StringConverter.convert(request.getParameter("WardName"));
        contest.setProvinceId(ProvinceDAO.Instance().getProvinceId(ProvinceName));
        contest.setWardId(WardDAO.Instance().getWardId(WardName));
        contest.setDistrictId(DistrictDAO.Instance().getDistrictId(DistrictName));

        contest = StringConverter.convert(contest);
        return contest;
    }
}
