package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 资讯表实体类
 */
@Data
@TableName("t_news")
public class News {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;            // 资讯ID

    private String title;            // 标题

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String brief = "";

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String author = "";

    private String cover;            // 封面

    private String source;           // 来源

    private String label;            // 标签

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer browseNum = 0;       // 浏览量

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer maxStudyTime = 0;    // 最大学习时长

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String content = "<div style=\"line-height: 2;\">\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　原标题：李克强主持召开中央应对新冠肺炎疫情工作领导小组会议</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　部署提高检测能力做好对重点地区重点人群应检尽检工作</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　抓好各地常态化防控推进生产生活秩序全面恢复</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　王沪宁出席</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　新华社北京4月16日电 4月16日，中共中央政治局常委、国务院总理、中央应对新冠肺炎疫情工作领导小组组长李克强主持召开领导小组会议。</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　中共中央政治局常委、中央应对新冠肺炎疫情工作领导小组副组长王沪宁出席。</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　会议指出，要认真贯彻习近平总书记重要讲话精神，按照中央应对疫情工作领导小组部署，毫不松懈做好精准防控，突出重点加强边境地区、口岸城市疫情防控，排查消除聚集性疫情风险隐患，有力有序推动复工复产提速扩面。</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　会议指出，当前我国疫情防控任务仍然艰巨，境外输入和个别地方本地疫情交织叠加，要高度重视，不能掉以轻心。各地要压实责任，增强紧迫感，加快提高核酸和抗体检测能力，扩大检测范围，做好对重点地区重点人群应检尽检工作，这有利于巩固防控成果，既对人民群众有益，又可为复工复产提供保障。要做好社区和公共场所常态化科学精准防控，落实&ldquo;筛查-诊断-报告-隔离&rdquo;闭环管理要求，一旦发现疫情立即精准围堵。加强对被隔离人员的人文关怀。出现局部聚集性疫情的地方，要抓紧查清感染原因，切断传播路径，尤其要补上医院防控漏洞，做好医护人员防护，防止交叉感染。坚持实事求是、公开透明发布疫情信息。</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　会议要求，要根据疫情跨境输入形势变化，突出重点做好防控。边境省份要有针对性完善防控方案，一市一策，分片包干，落实责任，加强边境地区防控薄弱环节。在边境省份内部调配医护力量的同时，抓紧从全国增派疾控专家和医疗力量，抽调重症、呼吸等领域医疗专家支援边境地区、口岸城市，重点帮助当地提升病例诊断和患者救治能力。加大疫情防控人员和物资等保障力度，切实做好检疫检测、隔离观察点、方舱医院、定点救治医院等应急准备。</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　会议指出，要统筹推进疫情防控和经济社会发展，抓紧梳理总结各地好的经验做法，完善常态化防控下推进全面复工复产的措施。找好精准防控和推动经济社会秩序恢复的工作结合点，促进区域之间人员和要素正常流动、各类经济活动正常开展，为经济社会发展营造好的大环境。会议还听取了离汉通道管控解除后武汉市防控工作和复工复产情况汇报，要求武汉市继续抓紧抓实抓细防控工作，全力做好重症患者救治，优化社区防控措施，加强与其他地区的协调配合，加快全面恢复正常医疗服务，稳步恢复经济社会秩序。</span></p>\n" +
            "<p><span style=\"font-family: georgia, palatino, serif;\">　　领导小组成员丁薛祥、黄坤明、蔡奇、王毅、肖捷、赵克志参加会议。</span></p>\n" +
            "</div>";          // 内容

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer starNum = 0;         // 星级评分

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer state = 4;           // 状态 (0-未发布, 1-已发布)

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer managerId = 0;       // 管理员ID

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;    // 创建时间

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;    // 更新时间
}
