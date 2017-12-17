package ua.training.model.dao.mapper;

import ua.training.model.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CategoryMapper implements EntityMapper<Category> {
    @Override
    public Category extractFromResultSet(ResultSet rs) throws SQLException {

        Category result = new Category();

        result.setIdCategory(rs.getInt("idcategory") );
        result.setCategoryName(rs.getString("categoryname") );

        return result;
    }

    @Override
    public Category makeUnique(Map<Integer, Category> map, Category category) {
        int key = category.getIdCategory();
        map.putIfAbsent(key, category);
        return map.get(key);
    }
}
