package com.developer.SpringMySql.CustomRepoImplement;

import com.developer.SpringMySql.customRepo.EmployeeCustomRepo;
import com.developer.SpringMySql.dto.DepartmentDto;
import com.developer.SpringMySql.dto.EmployeeDto;
import com.developer.SpringMySql.models.Employee;
//import com.developer.SpringMySql.models.Employee_;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeCustomRepoImp implements EmployeeCustomRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getById(Integer empId) {
        return null;
    }

    @Override
    public List<Employee> getByEmpId(Integer empId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        List<Order> orders = new ArrayList<>();
        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.distinct(true);
        final TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Integer getNumberOfItemsByRequest(EmployeeDto employeeDto) {
        String query = "select COUNT(*) from employee WHERE employee.emp_name like ?";

        Query q = entityManager.createNativeQuery(query);
        q.setParameter(1, "%" + Objects.toString(employeeDto.getEmpName(), "") + "%");
        List<Object[]> list = (List<Object[]>) q.getResultList();
        int count = ((Number) q.getSingleResult()).intValue();
        return count;


    }

    @Override
    public ArrayList<EmployeeDto> search(EmployeeDto employeeDto, Pageable pageable) {
        try {
            String query = "select e.emp_id,e.emp_name,e.Age,e.Sex,e.Birthday,e.depart_id,d.depart_name from employee e INNER JOIN department d on e.depart_id = d.depart_id WHERE e.emp_name like ?";

            if(employeeDto.getDepartId() != 0){
                query += " And e.depart_id = " + employeeDto.getDepartId();
            }

            query += " ORDER BY e.emp_id desc LIMIT ? OFFSET ?  ";
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, "%" + Objects.toString(employeeDto.getEmpName(), "") + "%");
            q.setParameter(2, pageable.getPageSize());
            q.setParameter(3, pageable.getPageNumber() * pageable.getPageSize());
            List<Object[]> list = (List<Object[]>) q.getResultList();
            ArrayList result = new ArrayList();
            for (Object[] obj : list){
                EmployeeDto de = new EmployeeDto(
                        (Integer) obj[0],(String) obj [1],(Integer) obj [2],(Integer) obj[3],(Date) obj[4],(Integer) obj[5],(String) obj[6]);
                result.add(de);
            }
            return result;
        }catch (Exception ex){
            return null;
        }
    }
}
