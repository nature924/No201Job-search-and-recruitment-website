package cn.jia.dto;

import java.util.List;

/**
 * Created by matou on 2019/11/24.
 */
public class ResumeDto {
    private  int id;
    private int userId;
    private String positionName;//投递岗位
    private int flag;//1表示在线简历2表示附件简历
    private int R;
    private InformationDto informationDto;
    private EducationDto educationDto;
    private CampusDto campusDto;
    private ProjectDto projectDto;
    private SkillDto skillDto;
    private WorkDto workDto;

    private GradeDto gradeDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public InformationDto getInformationDto() {
        return informationDto;
    }

    public void setInformationDto(InformationDto informationDto) {
        this.informationDto = informationDto;
    }

    public EducationDto getEducationDto() {
        return educationDto;
    }

    public void setEducationDto(EducationDto educationDto) {
        this.educationDto = educationDto;
    }

    public CampusDto getCampusDto() {
        return campusDto;
    }

    public void setCampusDto(CampusDto campusDto) {
        this.campusDto = campusDto;
    }

    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public void setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
    }

    public SkillDto getSkillDto() {
        return skillDto;
    }

    public void setSkillDto(SkillDto skillDto) {
        this.skillDto = skillDto;
    }

    public WorkDto getWorkDto() {
        return workDto;
    }

    public void setWorkDto(WorkDto workDto) {
        this.workDto = workDto;
    }

    public GradeDto getGradeDto() {
        return gradeDto;
    }

    public void setGradeDto(GradeDto gradeDto) {
        this.gradeDto = gradeDto;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    @Override
    public String toString() {
        return "ResumeDto{" +
                "userId=" + userId +
                ", positionName='" + positionName + '\'' +
                ", flag=" + flag +
                ", informationDto=" + informationDto +
                ", educationDto=" + educationDto +
                ", campusDto=" + campusDto +
                ", projectDto=" + projectDto +
                ", skillDto=" + skillDto +
                ", workDto=" + workDto +
                ", gradeDto=" + gradeDto +
                '}';
    }
}
