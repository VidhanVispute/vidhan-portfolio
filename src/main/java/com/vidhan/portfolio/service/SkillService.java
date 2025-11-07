package com.vidhan.portfolio.service;

import com.vidhan.portfolio.entity.Skill;
import com.vidhan.portfolio.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
    
    private final SkillRepository skillRepository;
    
    public List<Skill> getAllSkills() {
        return skillRepository.findAllByOrderByDisplayOrderAsc();
    }
    
    public List<Skill> getSkillsByCategory(String category) {
        return skillRepository.findByCategoryOrderByDisplayOrderAsc(category);
    }
    
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }
}