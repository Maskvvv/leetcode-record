package leetcode.editor.cn;
//
// 要求接龙形式，地级市、县级市和直辖市皆可。例如“遵义乌鲁木齐齐哈尔滨州”就六个城市名相连，“黄石嘴山南宁德阳江门”短短十个字甚至由八个城市相连，各位知友，请在此肆意发挥你的脑洞吧！
//
//


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;


//Java：将中国城市名首尾相连，最多能连几个
public class LongestCity {

    private static String file;
    public static void main(String[] args) throws IOException {
        file = args[0];
        Solution solution = new LongestCity().new Solution();
        String city = "北京,东城,西城,朝阳,丰台,石景山,海淀,门头沟,房山,通州,顺义,昌平,大兴,怀柔,平谷,密云,延庆,天津,和平,河东,河西,南开,河北,红桥,东丽,西青,津南,北辰,武清,宝坻,滨海新,宁河,静海,蓟州,石家庄,长安,桥西,新华,井陉矿,裕华,藁城,鹿泉,栾城,井陉,正定,行唐,灵寿,高邑,深泽,赞皇,无极,平山,元氏,赵,辛集,晋州,新乐,唐山,路南,路北,古冶,开平,丰南,丰润,曹妃甸,滦南,乐亭,迁西,玉田,遵化,迁安,滦州,秦皇岛,海港,山海关,北戴河,抚宁,青龙满族,昌黎,卢龙,邯郸,邯山,丛台,复兴,峰峰矿,肥乡,永年,临漳,成安,大名,涉,磁,邱,鸡泽,广平,馆陶,魏,曲周,武安,邢台,襄都,信都,任泽,南和,临城,内丘,柏乡,隆尧,宁晋,巨鹿,新河,广宗,平乡,威,清河,临西,南宫,沙河,保定,竞秀,莲池,满城,清苑,徐水,涞水,阜平,定兴,唐,高阳,容城,涞源,望都,安新,易,曲阳,蠡,顺平,博野,雄,涿州,定州,安国,高碑店,张家口,桥东,桥西,宣化,下花园,万全,崇礼,张北,康保,沽源,尚义,蔚,阳原,怀安,怀来,涿鹿,赤城,承德,双桥,双滦,鹰手营子矿,承德,兴隆,滦平,隆化,丰宁满族,宽城满族,围场满族蒙古族,平泉,沧州,新华,运河,沧,青,东光,海兴,盐山,肃宁,南皮,吴桥,献,孟村回族,泊头,任丘,黄骅,河间,廊坊,安次,广阳,固安,永清,香河,大城,文安,大厂回族,霸州,三河,衡水,桃城,冀州,枣强,武邑,武强,饶阳,安平,故城,景,阜城,深州,太原,小店,迎泽,杏花岭,尖草坪,万柏林,晋源,清徐,阳曲,娄烦,古交,大同,新荣,平城,云冈,云州,阳高,天镇,广灵,灵丘,浑源,左云,阳泉,城,矿,郊,平定,盂,长治,潞州,上党,屯留,潞城,襄垣,平顺,黎城,壶关,长子,武乡,沁,沁源,晋城,城,沁水,阳城,陵川,泽州,高平,朔州,朔城,平鲁,山阴,应,右玉,怀仁,晋中,榆次,太谷,榆社,左权,和顺,昔阳,寿阳,祁,平遥,灵石,介休,运城,盐湖,临猗,万荣,闻喜,稷山,新绛,绛,垣曲,夏,平陆,芮城,永济,河津,忻州,忻府,定襄,五台,代,繁峙,宁武,静乐,神池,五寨,岢岚,河曲,保德,偏关,原平,临汾,尧都,曲沃,翼城,襄汾,洪洞,古,安泽,浮山,吉,乡宁,大宁,隰,永和,蒲,汾西,侯马,霍州,吕梁,离石,文水,交城,兴,临,柳林,石楼,岚,方山,中阳,交口,孝义,汾阳,呼和浩特,新城,回民,玉泉,赛罕,土默特左,托克托,和林格尔,清水河,武川,包头,东河,昆都仑,青山,石拐,白云鄂博矿,九原,土默特右,固阳,达尔罕茂明安联合,乌海,海勃湾,海南,乌达,赤峰,红山,元宝山,松山,阿鲁科尔沁,巴林左,巴林右,林西,克什克腾,翁牛特,喀喇沁,宁城,敖汉,通辽,科尔沁,科尔沁左翼中,科尔沁左翼后,开鲁,库伦,奈曼,扎鲁特,霍林郭勒,鄂尔多斯,东胜,康巴什,达拉特,准格尔,鄂托克前,鄂托克,杭锦,乌审,伊金霍洛,呼伦贝尔,海拉尔,扎赉诺尔,阿荣,莫力达瓦达斡尔族,鄂伦春,鄂温克族,陈巴尔虎,新巴尔虎左,新巴尔虎右,满洲里,牙克石,扎兰屯,额尔古纳,根河,巴彦淖尔,临河,五原,磴口,乌拉特前,乌拉特中,乌拉特后,杭锦后,乌兰察布,集宁,卓资,化德,商都,兴和,凉城,察哈尔右翼前,察哈尔右翼中,察哈尔右翼后,四子王,丰镇,兴安盟,乌兰浩特,阿尔山,科尔沁右翼前,科尔沁右翼中,扎赉特,突泉,锡林郭勒盟,二连浩特,锡林浩特,阿巴嘎,苏尼特左,苏尼特右,东乌珠穆沁,西乌珠穆沁,太仆寺,镶黄,正镶白,正蓝,多伦,阿拉善盟,阿拉善左,阿拉善右,额济纳,沈阳,和平,沈河,大东,皇姑,铁西,苏家屯,浑南,沈北新,于洪,辽中,康平,法库,新民,大连,中山,西岗,沙河口,甘井子,旅顺口,金州,普兰店,长海,瓦房店,庄河,鞍山,铁东,铁西,立山,千山,台安,岫岩满族,海城,抚顺,新抚,东洲,望花,顺城,抚顺,新宾满族,清原满族,本溪,平山,溪湖,明山,南芬,本溪满族,桓仁满族,丹东,元宝,振兴,振安,宽甸满族,东港,凤城,锦州,古塔,凌河,太和,黑山,义,凌海,北镇,营口,站前,西市,鲅鱼圈,老边,盖州,大石桥,阜新,海州,新邱,太平,清河门,细河,阜新蒙古族,彰武,辽阳,白塔,文圣,宏伟,弓长岭,太子河,辽阳,灯塔,盘锦,双台子,兴隆台,大洼,盘山,铁岭,银州,清河,铁岭,西丰,昌图,调兵山,开原,朝阳,双塔,龙城,朝阳,建平,喀喇沁左翼蒙古族,北票,凌源,葫芦岛,连山,龙港,南票,绥中,建昌,兴城,长春,南关,宽城,朝阳,二道,绿园,双阳,九台,农安,榆树,德惠,公主岭,吉林,昌邑,龙潭,船营,丰满,永吉,蛟河,桦甸,舒兰,磐石,四平,铁西,铁东,梨树,伊通满族,双辽,辽源,龙山,西安,东丰,东辽,通化,东昌,二道江,通化,辉南,柳河,梅河口,集安,白山,浑江,江源,抚松,靖宇,长白朝鲜族,临江,松原,宁江,前郭尔罗斯蒙古族,长岭,乾安,扶余,白城,洮北,镇赉,通榆,洮南,大安,延边朝鲜族,延吉,图们,敦化,珲春,龙井,和龙,汪清,安图,哈尔滨,道里,南岗,道外,平房,松北,香坊,呼兰,阿城,双城,依兰,方正,宾,巴彦,木兰,通河,延寿,尚志,五常,齐齐哈尔,龙沙,建华,铁锋,昂昂溪,富拉尔基,碾子山,梅里斯达斡尔族,龙江,依安,泰来,甘南,富裕,克山,克东,拜泉,讷河,鸡西,鸡冠,恒山,滴道,梨树,城子河,麻山,鸡东,虎林,密山,鹤岗,向阳,工农,南山,兴安,东山,兴山,萝北,绥滨,双鸭山,尖山,岭东,四方台,宝山,集贤,友谊,宝清,饶河,大庆,萨尔图,龙凤,让胡路,红岗,大同,肇州,肇源,林甸,杜尔伯特蒙古族,伊春,伊美,乌翠,友好,嘉荫,汤旺,丰林,大箐山,南岔,金林,铁力,佳木斯,向阳,前进,东风,郊,桦南,桦川,汤原,抚远,同江,富锦,七台河,新兴,桃山,茄子河,勃利,牡丹江,东安,阳明,爱民,西安,林口,绥芬河,海林,宁安,穆棱,东宁,黑河,爱辉,逊克,孙吴,北安,五大连池,嫩江,绥化,北林,望奎,兰西,青冈,庆安,明水,绥棱,安达,肇东,海伦,大兴安岭地,漠河,呼玛,塔河,上海,黄浦,徐汇,长宁,静安,普陀,虹口,杨浦,闵行,宝山,嘉定,浦东新,金山,松江,青浦,奉贤,崇明,南京,玄武,秦淮,建邺,鼓楼,浦口,栖霞,雨花台,江宁,六合,溧水,高淳,无锡,锡山,惠山,滨湖,梁溪,新吴,江阴,宜兴,徐州,鼓楼,云龙,贾汪,泉山,铜山,丰,沛,睢宁,新沂,邳州,常州,天宁,钟楼,新北,武进,金坛,溧阳,苏州,虎丘,吴中,相城,姑苏,吴江,常熟,张家港,昆山,太仓,南通,通州,崇川,海门,如东,启东,如皋,海安,连云港,连云,海州,赣榆,东海,灌云,灌南,淮安,淮安,淮阴,清江浦,洪泽,涟水,盱眙,金湖,盐城,亭湖,盐都,大丰,响水,滨海,阜宁,射阳,建湖,东台,扬州,广陵,邗江,江都,宝应,仪征,高邮,镇江,京口,润州,丹徒,丹阳,扬中,句容,泰州,海陵,高港,姜堰,兴化,靖江,泰兴,宿迁,宿城,宿豫,沭阳,泗阳,泗洪,杭州,上城,下城,江干,拱墅,西湖,滨江,萧山,余杭,富阳,临安,桐庐,淳安,建德,宁波,海曙,江北,北仑,镇海,鄞州,奉化,象山,宁海,余姚,慈溪,温州,鹿城,龙湾,瓯海,洞头,永嘉,平阳,苍南,文成,泰顺,瑞安,乐清,龙港,嘉兴,南湖,秀洲,嘉善,海盐,海宁,平湖,桐乡,湖州,吴兴,南浔,德清,长兴,安吉,绍兴,越城,柯桥,上虞,新昌,诸暨,嵊州,金华,婺城,金东,武义,浦江,磐安,兰溪,义乌,东阳,永康,衢州,柯城,衢江,常山,开化,龙游,江山,舟山,定海,普陀,岱山,嵊泗,台州,椒江,黄岩,路桥,三门,天台,仙居,温岭,临海,玉环,丽水,莲都,青田,缙云,遂昌,松阳,云和,庆元,景宁畲族,龙泉,合肥,瑶海,庐阳,蜀山,包河,长丰,肥东,肥西,庐江,巢湖,芜湖,镜湖,鸠江,弋江,湾沚,繁昌,南陵,无为,蚌埠,龙子湖,蚌山,禹会,淮上,怀远,五河,固镇,淮南,大通,田家庵,谢家集,八公山,潘集,凤台,寿,马鞍山,花山,雨山,博望,当涂,含山,和,淮北,杜集,相山,烈山,濉溪,铜陵,铜官,义安,郊,枞阳,安庆,迎江,大观,宜秀,怀宁,太湖,宿松,望江,岳西,桐城,潜山,黄山,屯溪,黄山,徽州,歙,休宁,黟,祁门,滁州,琅琊,南谯,来安,全椒,定远,凤阳,天长,明光,阜阳,颍州,颍东,颍泉,临泉,太和,阜南,颍上,界首,宿州,埇桥,砀山,萧,灵璧,泗,六安,金安,裕安,叶集,霍邱,舒城,金寨,霍山,亳州,谯城,涡阳,蒙城,利辛,池州,贵池,东至,石台,青阳,宣城,宣州,郎溪,泾,绩溪,旌德,宁国,广德,福州,鼓楼,台江,仓山,马尾,晋安,长乐,闽侯,连江,罗源,闽清,永泰,平潭,福清,厦门,思明,海沧,湖里,集美,同安,翔安,莆田,城厢,涵江,荔城,秀屿,仙游,三明,梅列,三元,明溪,清流,宁化,大田,尤溪,沙,将乐,泰宁,建宁,永安,泉州,鲤城,丰泽,洛江,泉港,惠安,安溪,永春,德化,金门,石狮,晋江,南安,漳州,芗城,龙文,云霄,漳浦,诏安,长泰,东山,南靖,平和,华安,龙海,南平,延平,建阳,顺昌,浦城,光泽,松溪,政和,邵武,武夷山,建瓯,龙岩,新罗,永定,长汀,上杭,武平,连城,漳平,宁德,蕉城,霞浦,古田,屏南,寿宁,周宁,柘荣,福安,福鼎,南昌,东湖,西湖,青云谱,青山湖,新建,红谷滩,南昌,安义,进贤,景德镇,昌江,珠山,浮梁,乐平,萍乡,安源,湘东,莲花,上栗,芦溪,九江,濂溪,浔阳,柴桑,武宁,修水,永修,德安,都昌,湖口,彭泽,瑞昌,共青城,庐山,新余,渝水,分宜,鹰潭,月湖,余江,贵溪,赣州,章贡,南康,赣县,信丰,大余,上犹,崇义,安远,定南,全南,宁都,于都,兴国,会昌,寻乌,石城,瑞金,龙南,吉安,吉州,青原,吉安,吉水,峡江,新干,永丰,泰和,遂川,万安,安福,永新,井冈山,宜春,袁州,奉新,万载,上高,宜丰,靖安,铜鼓,丰城,樟树,高安,抚州,临川,东乡,南城,黎川,南丰,崇仁,乐安,宜黄,金溪,资溪,广昌,上饶,信州,广丰,广信,玉山,铅山,横峰,弋阳,余干,鄱阳,万年,婺源,德兴,济南,历下,市中,槐荫,天桥,历城,长清,章丘,济阳,莱芜,钢城,平阴,商河,高新,青岛,市南,市北,黄岛,崂山,李沧,城阳,即墨,胶州,平度,莱西,西海岸新,淄博,淄川,张店,博山,临淄,周村,桓台,高青,沂源,高新,枣庄,市中,薛城,峄城,台儿庄,山亭,滕州,高新,东营,东营,河口,垦利,利津,广饶,东营经济技术开发,烟台,芝罘,福山,牟平,莱山,蓬莱,龙口,莱阳,莱州,招远,栖霞,海阳,开发,高新,潍坊,潍城,寒亭,坊子,奎文,临朐,昌乐,青州,诸城,寿光,安丘,高密,昌邑,高新,济宁,任城,兖州,微山,鱼台,金乡,嘉祥,汶上,泗水,梁山,曲阜,邹城,泰安,泰山,高新技术产业开发,岱岳,宁阳,东平,新泰,肥城,威海,环翠,文登,火炬高技术产业开发,经济技术开发,荣成,乳山,日照,东港,岚山,五莲,莒,临沂,兰山,罗庄,河东,沂南,郯城,沂水,兰陵,费,平邑,莒南,蒙阴,临沭,德州,德城,陵城,宁津,庆云,临邑,齐河,平原,夏津,武城,乐陵,禹城,聊城,东昌府,茌平,阳谷,莘,东阿,冠,高唐,临清,滨州,滨城,沾化,惠民,阳信,无棣,博兴,邹平,菏泽,牡丹,定陶,曹,单,成武,巨野,郓城,鄄城,东明,郑州,中原,二七,管城回族,金水,上街,惠济,中牟,巩义,荥阳,新密,新郑,登封,开封,龙亭,顺河回族,鼓楼,禹王台,祥符,杞,通许,尉氏,兰考,洛阳,老城,西工,瀍河回族,涧西,吉利,洛龙,孟津,新安,栾川,嵩,汝阳,宜阳,洛宁,伊川,偃师,平顶山,新华,卫东,石龙,湛河,宝丰,叶,鲁山,郏,舞钢,汝州,安阳,文峰,北关,殷都,龙安,安阳,汤阴,滑,内黄,林州,鹤壁,鹤山,山城,淇滨,浚,淇,新乡,红旗,卫滨,凤泉,牧野,新乡,获嘉,原阳,延津,封丘,卫辉,辉县,长垣,焦作,解放,中站,马村,山阳,修武,博爱,武陟,温,沁阳,孟州,濮阳,华龙,清丰,南乐,范,台前,濮阳,许昌,魏都,建安,鄢陵,襄城,禹州,长葛,漯河,源汇,郾城,召陵,舞阳,临颍,三门峡,湖滨,陕州,渑池,卢氏,义马,灵宝,南阳,宛城,卧龙,南召,方城,西峡,镇平,内乡,淅川,社旗,唐河,新野,桐柏,邓州,商丘,梁园,睢阳,民权,睢,宁陵,柘城,虞城,夏邑,永城,信阳,浉河,平桥,罗山,光山,新,商城,固始,潢川,淮滨,息,周口,川汇,淮阳,扶沟,西华,商水,沈丘,郸城,太康,鹿邑,项城,驻马店,驿城,西平,上蔡,平舆,正阳,确山,泌阳,汝南,遂平,新蔡,直辖县级,济源,武汉,江岸,江汉,硚口,汉阳,武昌,青山,洪山,东西湖,汉南,蔡甸,江夏,黄陂,新洲,黄石,黄石港,西塞山,下陆,铁山,阳新,大冶,十堰,茅箭,张湾,郧阳,郧西,竹山,竹溪,房,丹江口,宜昌,西陵,伍家岗,点军,猇亭,夷陵,远安,兴山,秭归,长阳土家族,五峰土家族,宜都,当阳,枝江,襄阳,襄城,樊城,襄州,南漳,谷城,保康,老河口,枣阳,宜城,鄂州,梁子湖,华容,鄂城,荆门,东宝,掇刀,沙洋,钟祥,京山,孝感,孝南,孝昌,大悟,云梦,应城,安陆,汉川,荆州,沙市,荆州,公安,江陵,石首,洪湖,松滋,监利,黄冈,黄州,团风,红安,罗田,英山,浠水,蕲春,黄梅,麻城,武穴,咸宁,咸安,嘉鱼,通城,崇阳,通山,赤壁,随州,曾都,随,广水,恩施土家族苗族,恩施,利川,建始,巴东,宣恩,咸丰,来凤,鹤峰,直辖县级,仙桃,潜江,天门,神农架林,长沙,芙蓉,天心,岳麓,开福,雨花,望城,长沙,浏阳,宁乡,株洲,荷塘,芦淞,石峰,天元,渌口,攸,茶陵,炎陵,醴陵,湘潭,雨湖,岳塘,湘潭,湘乡,韶山,衡阳,珠晖,雁峰,石鼓,蒸湘,南岳,衡阳,衡南,衡山,衡东,祁东,耒阳,常宁,邵阳,双清,大祥,北塔,新邵,邵阳,隆回,洞口,绥宁,新宁,城步苗族,武冈,邵东,岳阳,岳阳楼,云溪,君山,岳阳,华容,湘阴,平江,汨罗,临湘,常德,武陵,鼎城,安乡,汉寿,澧,临澧,桃源,石门,津市,张家界,永定,武陵源,慈利,桑植,益阳,资阳,赫山,南,桃江,安化,沅江,郴州,北湖,苏仙,桂阳,宜章,永兴,嘉禾,临武,汝城,桂东,安仁,资兴,永州,零陵,冷水滩,祁阳,东安,双牌,道,江永,宁远,蓝山,新田,江华瑶族,怀化,鹤城,中方,沅陵,辰溪,溆浦,会同,麻阳苗族,新晃侗族,芷江侗族,靖州苗族侗族,通道侗族,洪江,娄底,娄星,双峰,新化,冷水江,涟源,湘西土家族苗族,吉首,泸溪,凤凰,花垣,保靖,古丈,永顺,龙山,广州,荔湾,越秀,海珠,天河,白云,黄埔,番禺,花都,南沙,从化,增城,韶关,武江,浈江,曲江,始兴,仁化,翁源,乳源瑶族,新丰,乐昌,南雄,深圳,罗湖,福田,南山,宝安,龙岗,盐田,龙华,坪山,光明,珠海,香洲,斗门,金湾,汕头,龙湖,金平,濠江,潮阳,潮南,澄海,南澳,佛山,禅城,南海,顺德,三水,高明,江门,蓬江,江海,新会,台山,开平,鹤山,恩平,湛江,赤坎,霞山,坡头,麻章,遂溪,徐闻,廉江,雷州,吴川,茂名,茂南,电白,高州,化州,信宜,肇庆,端州,鼎湖,高要,广宁,怀集,封开,德庆,四会,惠州,惠城,惠阳,博罗,惠东,龙门,梅州,梅江,梅县,大埔,丰顺,五华,平远,蕉岭,兴宁,汕尾,城,海丰,陆河,陆丰,河源,源城,紫金,龙川,连平,和平,东源,阳江,江城,阳东,阳西,阳春,清远,清城,清新,佛冈,阳山,连山壮族瑶族,连南瑶族,英德,连州,东莞,莞城,南城,万江,石碣镇,石龙镇,茶山镇,石排镇,企石镇,横沥镇,桥头镇,谢岗镇,东坑镇,常平镇,寮步镇,大朗镇,麻涌镇,中堂镇,高埗镇,樟木头镇,大岭山镇,望牛墩镇,黄江镇,洪梅镇,清溪镇,沙田镇,道滘镇,塘厦镇,虎门镇,厚街镇,凤岗镇,长安镇,中山,石岐,南,五桂山,火炬开发,黄圃镇,南头镇,东凤镇,阜沙镇,小榄镇,东升镇,古镇镇,横栏镇,三角镇,民众镇,南朗镇,港口镇,大涌镇,沙溪镇,三乡镇,板芙镇,神湾镇,坦洲镇,潮州,湘桥,潮安,饶平,揭阳,榕城,揭东,揭西,惠来,普宁,云浮,云城,云安,新兴,郁南,罗定,南宁,兴宁,青秀,江南,西乡塘,良庆,邕宁,武鸣,隆安,马山,上林,宾阳,横,柳州,城中,鱼峰,柳南,柳北,柳江,柳城,鹿寨,融安,融水苗族,三江侗族,桂林,秀峰,叠彩,象山,七星,雁山,临桂,阳朔,灵川,全州,兴安,永福,灌阳,龙胜各族,资源,平乐,恭城瑶族,荔浦,梧州,万秀,长洲,龙圩,苍梧,藤,蒙山,岑溪,北海,海城,银海,铁山港,合浦,防城港,港口,防城,上思,东兴,钦州,钦南,钦北,灵山,浦北,贵港,港北,港南,覃塘,平南,桂平,玉林,玉州,福绵,容,陆川,博白,兴业,北流,百色,右江,田阳,田东,德保,那坡,凌云,乐业,田林,西林,隆林各族,靖西,平果,贺州,八步,平桂,昭平,钟山,富川瑶族,河池,金城江,宜州,南丹,天峨,凤山,东兰,罗城仫佬族,环江毛南族,巴马瑶族,都安瑶族,大化瑶族,来宾,兴宾,忻城,象州,武宣,金秀瑶族,合山,崇左,江州,扶绥,宁明,龙州,大新,天等,凭祥,海口,秀英,龙华,琼山,美兰,三亚,海棠,吉阳,天涯,崖州,三沙,西沙,南沙,儋州,直辖县级,五指山,琼海,文昌,万宁,东方,定安,屯昌,澄迈,临高,白沙黎族,昌江黎族,乐东黎族,陵水黎族,保亭黎族苗族,琼中黎族苗族,重庆,万州,涪陵,渝中,大渡口,江北,沙坪坝,九龙坡,南岸,北碚,綦江,大足,渝北,巴南,黔江,长寿,江津,合川,永川,南川,璧山,铜梁,潼南,荣昌,开州,梁平,武隆,城口,丰都,垫江,忠,云阳,奉节,巫山,巫溪,石柱土家族,秀山土家族苗族,酉阳土家族苗族,彭水苗族土家族,成都,锦江,青羊,金牛,武侯,成华,龙泉驿,青白江,新都,温江,双流,郫都,新津,金堂,大邑,蒲江,都江堰,彭州,邛崃,崇州,简阳,自贡,自流井,贡井,大安,沿滩,荣,富顺,攀枝花,东,西,仁和,米易,盐边,泸州,江阳,纳溪,龙马潭,泸,合江,叙永,古蔺,德阳,旌阳,罗江,中江,广汉,什邡,绵竹,绵阳,涪城,游仙,安州,三台,盐亭,梓潼,北川羌族,平武,江油,广元,利州,昭化,朝天,旺苍,青川,剑阁,苍溪,遂宁,船山,安居,蓬溪,大英,射洪,内江,市中,东兴,威远,资中,隆昌,乐山,市中,沙湾,五通桥,金口河,犍为,井研,夹江,沐川,峨边彝族,马边彝族,峨眉山,南充,顺庆,高坪,嘉陵,南部,营山,蓬安,仪陇,西充,阆中,眉山,东坡,彭山,仁寿,洪雅,丹棱,青神,宜宾,翠屏,南溪,叙州,江安,长宁,高,珙,筠连,兴文,屏山,广安,广安,前锋,岳池,武胜,邻水,华蓥,达州,通川,达川,宣汉,开江,大竹,渠,万源,雅安,雨城,名山,荥经,汉源,石棉,天全,芦山,宝兴,巴中,巴州,恩阳,通江,南江,平昌,资阳,雁江,安岳,乐至,阿坝藏族羌族,马尔康,汶川,理,茂,松潘,九寨沟,金川,小金,黑水,壤塘,阿坝,若尔盖,红原,甘孜藏族,康定,泸定,丹巴,九龙,雅江,道孚,炉霍,甘孜,新龙,德格,白玉,石渠,色达,理塘,巴塘,乡城,稻城,得荣,凉山彝族,西昌,木里藏族,盐源,德昌,会理,会东,宁南,普格,布拖,金阳,昭觉,喜德,冕宁,越西,甘洛,美姑,雷波,贵阳,南明,云岩,花溪,乌当,白云,观山湖,开阳,息烽,修文,清镇,六盘水,钟山,六枝特,水城,盘州,遵义,红花岗,汇川,播州,桐梓,绥阳,正安,道真仡佬族苗族,务川仡佬族苗族,凤冈,湄潭,余庆,习水,赤水,仁怀,安顺,西秀,平坝,普定,镇宁布依族苗族,关岭布依族苗族,紫云苗族布依族,毕节,七星关,大方,黔西,金沙,织金,纳雍,威宁彝族回族苗族,赫章,铜仁,碧江,万山,江口,玉屏侗族,石阡,思南,印江土家族苗族,德江,沿河土家族,松桃苗族,黔西南布依族苗族,兴义市 ,兴仁,普安,晴隆,贞丰,望谟,册亨,安龙,黔东南苗族侗族,凯里,黄平,施秉,三穗,镇远,岑巩,天柱,锦屏,剑河,台江,黎平,榕江,从江,雷山,麻江,丹寨,黔南布依族苗族,都匀,福泉,荔波,贵定,瓮安,独山,平塘,罗甸,长顺,龙里,惠水,三都水族,昆明,五华,盘龙,官渡,西山,东川,呈贡,晋宁,富民,宜良,石林彝族,嵩明,禄劝彝族苗族,寻甸回族彝族 ,安宁,曲靖,麒麟,沾益,马龙,陆良,师宗,罗平,富源,会泽,宣威,玉溪,红塔,江川,通海,华宁,易门,峨山彝族,新平彝族傣族,元江哈尼族彝族傣族,澄江,保山,隆阳,施甸,龙陵,昌宁,腾冲,昭通,昭阳,鲁甸,巧家,盐津,大关,永善,绥江,镇雄,彝良,威信,水富,丽江,古城,玉龙纳西族,永胜,华坪,宁蒗彝族,普洱,思茅,宁洱哈尼族彝族,墨江哈尼族,景东彝族,景谷傣族彝族,镇沅彝族哈尼族拉祜族,江城哈尼族彝族,孟连傣族拉祜族佤族,澜沧拉祜族,西盟佤族,临沧,临翔,凤庆,云,永德,镇康,双江拉祜族佤族布朗族傣族,耿马傣族佤族,沧源佤族,楚雄彝族,楚雄,双柏,牟定,南华,姚安,大姚,永仁,元谋,武定,禄丰,红河哈尼族彝族,个旧,开远,蒙自,弥勒,屏边苗族,建水,石屏,泸西,元阳,红河,金平苗族瑶族傣族,绿春,河口瑶族,文山壮族苗族,文山,砚山,西畴,麻栗坡,马关,丘北,广南,富宁,西双版纳傣族,景洪,勐海,勐腊,大理白族,大理,漾濞彝族,祥云,宾川,弥渡,南涧彝族,巍山彝族回族,永平,云龙,洱源,剑川,鹤庆,德宏傣族景颇族,瑞丽,芒,梁河,盈江,陇川,怒江傈僳族,泸水,福贡,贡山独龙族怒族,兰坪白族普米族,迪庆藏族,香格里拉,德钦,维西傈僳族,拉萨,城关,堆龙德庆,达孜,林周,当雄,尼木,曲水,墨竹工卡,日喀则,桑珠孜,南木林,江孜,定日,萨迦,拉孜,昂仁,谢通门,白朗,仁布,康马,定结,仲巴,亚东,吉隆,聂拉木,萨嘎,岗巴,昌都,卡若,江达,贡觉,类乌齐,丁青,察雅,八宿,左贡,芒康,洛隆,边坝,巴宜,工布江达,米林,墨脱,波密,察隅,朗,乃东,扎囊,贡嘎,桑日,琼结,曲松,措美,洛扎,加查,隆子,错那,浪卡子,色尼,嘉黎,比如,聂荣,安多,申扎,索,班戈,巴青,尼玛,双湖,山南,那曲,阿里地,普兰,札达,噶尔,日土,革吉,改则,措勤,林芝,西安,新城,碑林,莲湖,灞桥,未央,雁塔,阎良,临潼,长安,高陵,鄠邑,蓝田,周至,铜川,王益,印台,耀州,宜君,宝鸡,渭滨,金台,陈仓,凤翔,岐山,扶风,眉,陇,千阳,麟游,凤,太白,咸阳,秦都,杨陵,渭城,三原,泾阳,乾,礼泉,永寿,长武,旬邑,淳化,武功,兴平,彬州,渭南,临渭,华州,潼关,大荔,合阳,澄城,蒲城,白水,富平,韩城,华阴,延安,宝塔,安塞,延长,延川,志丹,吴起,甘泉,富,洛川,宜川,黄龙,黄陵,子长,汉中,汉台,南郑,城固,洋,西乡,勉,宁强,略阳,镇巴,留坝,佛坪,榆林,榆阳,横山,府谷,靖边,定边,绥德,米脂,佳,吴堡,清涧,子洲,神木,安康,汉滨,汉阴,石泉,宁陕,紫阳,岚皋,平利,镇坪,旬阳,白河,商洛,商州,洛南,丹凤,商南,山阳,镇安,柞水,兰州,城关,七里河,西固,安宁,红古,永登,皋兰,榆中,嘉峪关,雄关,长城,镜铁,金昌,金川,永昌,白银,白银,平川,靖远,会宁,景泰,天水,秦州,麦积,清水,秦安,甘谷,武山,张家川回族,武威,凉州,民勤,古浪,天祝藏族,张掖,甘州,肃南裕固族,民乐,临泽,高台,山丹,平凉,崆峒,泾川,灵台,崇信,庄浪,静宁,华亭,酒泉,肃州,金塔,瓜州,肃北蒙古族,阿克塞哈萨克族,玉门,敦煌,庆阳,西峰,庆城,环,华池,合水,正宁,宁,镇原,定西,安定,通渭,陇西,渭源,临洮,漳,岷,陇南,武都,成,文,宕昌,康,西和,礼,徽,两当,临夏回族,临夏,临夏,康乐,永靖,广河,和政,东乡族,积石山保安族东乡族撒拉族,甘南藏族,合作,临潭,卓尼,舟曲,迭部,玛曲,碌曲,夏河,西宁,城东,城中,城西,城北,湟中,大通回族土族,湟源,海东,乐都,平安,民和回族土族,互助土族,化隆回族,循化撒拉族,海北藏族,门源回族,祁连,海晏,刚察,黄南藏族,同仁,尖扎,泽库,河南蒙古族,海南藏族,共和,同德,贵德,兴海,贵南,果洛藏族,玛沁,班玛,甘德,达日,久治,玛多,玉树藏族,玉树,杂多,称多,治多,囊谦,曲麻莱,海西蒙古族藏族,格尔木,德令哈,茫崖,乌兰,都兰,天峻,银川,兴庆,西夏,金凤,永宁,贺兰,灵武,石嘴山,大武口,惠农,平罗,吴忠,利通,红寺堡,盐池,同心,青铜峡,固原,原州,西吉,隆德,泾源,彭阳,中卫,沙坡头,中宁,海原,乌鲁木齐,天山,沙依巴克,新市,水磨沟,头屯河,达坂城,米东,乌鲁木齐,克拉玛依,独山子,克拉玛依,白碱滩,乌尔禾,高昌,鄯善,托克逊,伊州,巴里坤哈萨克,伊吾,吐鲁番,哈密,昌吉回族,昌吉,阜康,呼图壁,玛纳斯,奇台,吉木萨尔,木垒哈萨克,博尔塔拉蒙古,博乐,阿拉山口,精河,温泉,巴音郭楞蒙古,库尔勒,轮台,尉犁,若羌,且末,焉耆回族,和静,和硕,博湖,阿克苏地,阿克苏,库车,温宿,沙雅,新和,拜城,乌什,阿瓦提,柯坪,克孜勒苏柯尔克孜,阿图什,阿克陶,阿合奇,乌恰,喀什地,喀什,疏附,疏勒,英吉沙,泽普,莎车,叶城,麦盖提,岳普湖,伽师,巴楚,塔什库尔干塔吉克,和田地,和田,和田,墨玉,皮山,洛浦,策勒,于田,民丰,伊犁哈萨克,伊宁,奎屯,霍尔果斯,伊宁,察布查尔锡伯,霍城,巩留,新源,昭苏,特克斯,尼勒克,塔城地,塔城,乌苏,额敏,沙湾,托里,裕民,和布克赛尔蒙古,阿勒泰地,阿勒泰,布尔津,富蕴,福海,哈巴河,青河,吉木乃,直辖县级,石河子,阿拉尔,图木舒克,五家渠,北屯,铁门关,双河,可克达拉,昆玉,胡杨河,台北,松山,信义,大安,中山,中正,大同,万华,文山,南港,内湖,士林,北投,高雄,盐埕,鼓山,左营,楠梓,三民,新兴,前金,苓雅,前镇,旗津,小港,凤山,林园,大寮,大树,大社,仁武,鸟松,冈山,桥头,燕巢,田寮,阿莲,路竹,湖内,茄萣,永安,弥陀,梓官,旗山,美浓,六龟,甲仙,杉林,内门,茂林,桃源,那玛夏,基隆,中正,七堵,暖暖,仁爱,中山,安乐,信义,台中,中,东,南,西,北,西屯,南屯,北屯,丰原,东势,大甲,清水,沙鹿,梧栖,后里,神冈,潭子,大雅,新社,石冈,外埔,大安,乌日,大肚,龙井,雾峰,太平,大里,和平,台南,东,南,北,安南,安平,中西,新营,盐水,白河,柳营,后壁,东山,麻豆,下营,六甲,官田,大内,佳里,学甲,西港,七股,将军,北门,新化,善化,新市,安定,山上,玉井,楠西,南化,左镇,仁德,归仁,关庙,龙崎,永康,新竹,东,北,香山,嘉义,东,西,新北,板桥,三重,中和,永和,新庄,新店,树林,莺歌,三峡,淡水,汐止,瑞芳,土城,芦洲,五股,泰山,林口,深坑,石碇,坪林,三芝,石门,八里,平溪,双溪,贡寮,金山,万里,乌来,宜兰,宜兰,罗东镇,苏澳镇,头城镇,礁溪,壮围,员山,冬山,五结,三星,大同,南澳,桃园,桃园,中坜,平镇,八德,杨梅,芦竹,大溪镇,大园,龟山,龙潭,新屋,观音,复兴,新竹,竹北,竹东镇,新埔镇,关西镇,湖口,新丰,芎林,横山,北埔,宝山,峨眉,尖石,五峰,苗栗,苗栗,苑里镇,通霄镇,竹南镇,头份镇,后龙镇,卓兰镇,大湖,公馆,铜锣,南庄,头屋,三义,西湖,造桥,三湾,狮潭,泰安,彰化,彰化,鹿港镇,和美镇,线西,伸港,福兴,秀水,花坛,芬园,员林镇,溪湖镇,田中镇,大村,埔盐,埔心,永靖,社头,二水,北斗镇,二林镇,田尾,埤头,芳苑,大城,竹塘,溪州,南投,南投,埔里镇,草屯镇,竹山镇,集集镇,名间,鹿谷,中寮,鱼池,国姓,水里,信义,仁爱,云林,斗六,斗南镇,虎尾镇,西螺镇,土库镇,北港镇,古坑,大埤,莿桐,林内,二仑,仑背,麦寮,东势,褒忠,台西,元长,四湖,口湖,水林,嘉义,太保,朴子,布袋镇,大林镇,民雄,溪口,新港,六脚,东石,义竹,鹿草,水上,中埔,竹崎,梅山,番路,大埔,阿里山,屏东,屏东,潮州镇,东港镇,恒春镇,万丹,长治,麟洛,九如,里港,盐埔,高树,万峦,内埔,竹田,新埤,枋寮,新园,崁顶,林边,南州,佳冬,琉球,车城,满州,枋山,三地门,雾台,玛家,泰武,来义,春日,狮子,牡丹,台东,台东,成功镇,关山镇,卑南,鹿野,池上,东河,长滨,太麻里,大武,绿岛,海端,延平,金峰,达仁,兰屿,花莲,花莲,凤林镇,玉里镇,新城,吉安,寿丰,光复,丰滨,瑞穗,富里,秀林,万荣,卓溪,澎湖,马公,湖西,白沙,西屿,望安,七美,金门,金城镇,金湖镇,金沙镇,金宁,烈屿,乌丘,连江,南竿,北竿,莒光,东引,香港岛,中西,湾仔,东,南,九龙,油尖旺,深水埗,九龙城,黄大仙,观塘,新界,荃湾,屯门,元朗,北,大埔,西贡,沙田,葵青,离岛,澳门半岛,花地玛堂,圣安多尼堂,大堂,望德堂,风顺堂,氹仔岛,嘉模堂,路环岛,圣方济各堂";
        //String city = "北京,东城,西城,朝阳,丰台,石景山,海淀,门头沟,房山,通州,顺义,昌平,大兴,怀柔,平谷,密云,延庆,天津,和平,河东,河西,南开,河北,红桥,东丽,西青,津南,北辰,武清,宝坻,滨海新,宁河,静海,蓟州,石家庄,长安,桥西,新华,井陉矿,裕华,藁城,鹿泉,栾城,井陉,正定,行唐,灵寿,高邑,深泽,赞皇,无极,平山,元氏,赵,辛集,晋州,新乐,唐山,路南,路北,古冶,开平,丰南,丰润,曹妃甸,滦南,乐亭,迁西,玉田,遵化,迁安,滦州,秦皇岛,海港,山海关,北戴河,抚宁,青龙满族,昌黎,卢龙,邯郸,邯山,丛台,复兴,峰峰矿,肥乡,永年,临漳,成安,大名,涉,磁,邱,鸡泽,广平,馆陶,魏,曲周,武安,邢台,襄都,信都,任泽,南和,临城,内丘,柏乡,隆尧,宁晋,巨鹿,新河,广宗,平乡,威,清河,临西,南宫,沙河,保定,竞秀,莲池,满城,清苑,徐水,涞水,阜平,定兴,唐,高阳,容城,涞源,望都,安新,易,曲阳,蠡,顺平,博野,雄,涿州,定州,安国,高碑店,张家口,桥东,桥西,宣化,下花园,万全,崇礼,张北,康保,沽源,尚义,蔚,阳原,怀安,怀来,涿鹿,赤城,承德,双桥,双滦,鹰手营子矿,承德,兴隆,滦平,隆化,丰宁满族,宽城满族,围场满族蒙古族,平泉,沧州,新华,运河,沧,青,东光,海兴,盐山,肃宁,南皮,吴桥,献,孟村回族,泊头,任丘,黄骅,河间,廊坊,安次,广阳,固安,永清,香河,大城,文安,大厂回族,霸州,三河,衡水,桃城,冀州,枣强,武邑,武强,饶阳,安平,故城,景,阜城,深州,太原,小店,迎泽,杏花岭,尖草坪,万柏林,晋源,清徐,阳曲,娄烦,古交,大同,新荣,平城,云冈,云州,阳高,天镇,广灵,灵丘,浑源,左云,阳泉,城,矿,郊,平定,盂,长治,潞州,上党,屯留,潞城,襄垣,平顺,黎城,壶关,长子,武乡,沁,沁源,晋城,城,沁水,阳城,陵川,泽州,高平,朔州,朔城,平鲁,山阴,应,右玉,怀仁,晋中,榆次,太谷,榆社,左权,和顺,昔阳,寿阳,祁,平遥,灵石,介休,运城,盐湖,临猗,万荣,闻喜,稷山,新绛,绛,垣曲,夏,平陆,芮城,永济,河津,忻州,忻府,定襄,五台,代,繁峙,宁武,静乐,神池,五寨,岢岚,河曲,保德,偏关,原平,临汾,尧都,曲沃,翼城,襄汾,洪洞,古,安泽,浮山,吉,乡宁";
        String[] cities = city.split(",");
        cities = new HashSet<>(Arrays.asList(cities)).toArray(new String[0]);

        System.out.println(solution.longestCity(cities));
    }

    class Solution {

        List<String> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        FileWriter fileWriter = new FileWriter(file);

        Solution() throws IOException {
        }

        public List<String> longestCity(String[] cities) throws IOException {
            backtracking(cities, new boolean[cities.length]);
            return res;
        }

        public void backtracking(String[] cities, boolean[] used) throws IOException {
            if (path.size() > res.size()) {
                res = new ArrayList<>(path);
                fileWriter.write(LocalDateTime.now() + " " + res.toString() + "\n");
            }

            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < cities.length; i++) {
                if (!used[i] && !set.contains(cities[i])) {
                    set.add(cities[i]);
                    if (path.isEmpty() || cities[i].charAt(0) == path.getLast().charAt(path.getLast().length() - 1)) {
                        path.addLast(cities[i]);
                        used[i] = true;

                        backtracking(cities, used);

                        used[i] = false;
                        path.removeLast();
                    }

                }
            }


        }
    }

}