package ua.training.controller;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.EventDao;
import ua.training.model.dao.implementation.JDBCEventDao;
import ua.training.model.entity.Event;
import ua.training.model.sort.EventSort;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet ("/servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletRequest.setCharacterEncoding("UTF-8");

        DaoFactory daoFactory = DaoFactory.getInstance();
        EventDao eventDao = daoFactory.createEventDao();

        Set<Event> events = eventDao.findAll();

        EventSort eventSort = new EventSort();
        List<Event> event = eventSort.sortEventsByDate(new ArrayList<>(events));

        List<Event> eventsByDate = eventDao.findByDate(LocalDate.of(2018, 01, 10));
        httpServletRequest.setAttribute("event", event);
        httpServletRequest.setAttribute("eventsByDate", eventsByDate);
        httpServletRequest.getRequestDispatcher("./WEB-INF/eventList.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
