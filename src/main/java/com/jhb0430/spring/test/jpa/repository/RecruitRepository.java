package com.jhb0430.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jhb0430.spring.test.jpa.domain.Recruit;



public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

	
	//id가 8인 공고를 조회
	// WHERE `id` = #{id};
//	public List<Recruit> findById(int id);
	
	//Request Parameter로 전달 받은 
//	company id로 해당하는 회사의 공고를 조회하세요.

	public List<Recruit> findByCompanyId(int companyId);
	public List<Recruit> findByCompanyIdOrderByIdDesc(int companyId);

	
	public List<Recruit> findByPositionAndType(String position, String type);

	// 정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
	// WHERE `type`='정규직' OR `salary` >= 9000;
	
	public  List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
// Between은 a이상 b 이하일때 쓰나본디 
	// 
	
	
	//5. 정렬 제한 조건
	//계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
	// WHERE `type`='계약직' ORDER BY `salary` DESC LIMIT 3;
	
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	
	//6. 범위 조회
	//성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 
	// WHERE `region` ='성남시 분당구' AND `salary` BETWEEN 7000 AND 8500

	public List<Recruit>findByRegionAndSalaryBetween(String region, int salary1, int salary2);
	
	
	
	//7. Native query
	//마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 
	//연봉 내림차순으로 조회하세요.
	// WHERE `deadline` > '2026-04-10' AND (`salary` >= 8100 AND `type`='정규직')
	// ORDER BY `salary` DESC
	
	@Query(value="SELECT * FROM `recruit` "
			+ "WHERE `deadline` > :deadline "
			+ "AND (`salary` >= :salary AND `type`= :type)"
			+ " ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> selectByDST(@Param("deadline") String deadline
//									@Param("deadline") LocalDate deadline
									,@Param("salary")int salary
									, @Param("type") String type);
		
	
}
