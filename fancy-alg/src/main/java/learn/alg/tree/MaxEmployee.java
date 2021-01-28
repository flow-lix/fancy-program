package learn.alg.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树计算最大出席员工
 */
public class MaxEmployee {

    private int getMaxHappy(Employee employee) {
        ReturnType returnType = getMaxEmployee(employee);
        return Math.max(returnType.yes, returnType.no);
    }

    private ReturnType getMaxEmployee(Employee employee) {
        if (employee == null) {
            return new ReturnType(0, 0);
        }
        int yes = 1;
        int no = 0;
        for (Employee e : employee.employeeList) {
            // 来，sub不来
            ReturnType returnType = getMaxEmployee(e);
            yes += returnType.no;
            no += Math.max(returnType.yes, returnType.no);
        }
        return new ReturnType(yes, no);
    }

    static class Employee {
        List<Employee> employeeList = new ArrayList<>();
    }

    static class ReturnType {
        int yes;
        int no;

        ReturnType(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

}
