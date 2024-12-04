package top.zhu.tcomadminapi.model.dto;

public class UpdateIndexCategoryDTO {
    private String name;
    private Integer isShow;
    private Integer sort;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
