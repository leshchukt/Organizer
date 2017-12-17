package ua.training.view;

public interface SQLQuery {
    String selectAll =
            "SELECT DISTINCT * FROM event " +
                    "LEFT JOIN category ON event.idcategory = category.idcategory " +
                    "left join event_has_oponent on event.idevent = event_has_oponent.idevent " +
                    "left join oponent on event_has_oponent.idoponent = oponent.idoponent";

}
