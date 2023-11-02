package com.developer.SpringMySql.CustomRepoImplement;

import com.developer.SpringMySql.customRepo.DepartmentCustomRepo;
import com.developer.SpringMySql.dto.DepartmentDto;
import com.developer.SpringMySql.models.Department;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class DepartmentCustomRepoImp implements DepartmentCustomRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ArrayList<DepartmentDto> search(DepartmentDto departmentDto, Pageable pageable) {

        try {
            String query = "select department.depart_id,department.depart_name,department.Description from department where department.depart_name like ?";

            query += " ORDER BY department.depart_id desc LIMIT ? OFFSET ?  ";
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, "%" + Objects.toString(departmentDto.getDepartName(), "") + "%");
            q.setParameter(2, pageable.getPageSize());
            q.setParameter(3, pageable.getPageNumber() * pageable.getPageSize());
            List<Object[]> list = (List<Object[]>) q.getResultList();
            ArrayList result = new ArrayList();
            for (Object[] obj : list){
                DepartmentDto de = new DepartmentDto(
                        (Integer) obj[0],(String) obj [1],(String) obj [2]
                );
                result.add(de);
            }
            return result;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Integer getNumberOfItemsByRequest(DepartmentDto departmentDto) {

    String query = "select COUNT(*) from department WHERE department.depart_name like ?";

        Query q = entityManager.createNativeQuery(query);
        q.setParameter(1, "%" + Objects.toString(departmentDto.getDepartName(), "") + "%");
        List<Object[]> list = (List<Object[]>) q.getResultList();
        int count = ((Number) q.getSingleResult()).intValue();
        return count;
    }

    @Override
    public void delete(Integer id) {
        Department department =entityManager.find(Department.class, id);
        entityManager.remove(department);
    }
}
