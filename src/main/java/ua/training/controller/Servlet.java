package ua.training.controller;

import ua.training.model.entity.Event;
import ua.training.model.service.EventService;

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

//@WebServlet ("/servlet")
public class Servlet extends HttpServlet {

    EventService eventService = new EventService();
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletRequest.setCharacterEncoding("UTF-8");

        Set<Event> events = eventService.getAllEvents();
        httpServletRequest.setAttribute("events", events);

        List<Event> sortedEvents = eventService.sortEventsByDate(new ArrayList<>(events));
        List<Event> eventsByDate = eventService.getEventsByDate(LocalDate.of(2018, 1, 10));
        List<Event> eventsWithinDates = eventService.getEventsWithinDates(
                LocalDate.of(2017, 12, 15),
                LocalDate.of(2018, 1, 9));
        List<Event> comingEvents = eventService.getEventsForNextWeek();


        httpServletRequest.setAttribute("sortedEvents", sortedEvents);
        httpServletRequest.setAttribute("eventsByDate", eventsByDate);
        httpServletRequest.setAttribute("eventsWithinDates", eventsWithinDates);
        httpServletRequest.setAttribute("comingEvents", comingEvents);

        httpServletRequest.getRequestDispatcher("./WEB-INF/eventList.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
