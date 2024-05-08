// 读取国安备案号, 返回各省的两位编号(如 11),省名称(如 北京),省简称(如 京)
import provinceData from '../json/province.json';
// 定义一个函数，用于返回province.json的数据
/**
 * 通过国安备案号获取省份信息( 省份id, 省份名称, 省份简称 )
 * @param nationIcp
 * @returns {{province, short: *, id}}
 */
export function getProvinces(nationIcp) {
  // 截取nationIcp的前两位
  const idPrefix = nationIcp.substring(0, 2);
  // 遍历province.json的数据,对比icp前缀,返回对应的省份信息
  const matchingProvince = provinceData.find(province => province.id.startsWith(idPrefix));
  console.log(matchingProvince)
  if (matchingProvince) {
     return {
      id: matchingProvince.id,
      province: matchingProvince.province,
      short: matchingProvince.short
    };
  } else {
    return "No match found";
  }
}

// 测试用例
// console.log(getProvinces('450000000000'));
