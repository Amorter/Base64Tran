### Base64Tran
#一个很新(XD)的Base64算法
#灵感来源于
#某软件前端进行了账号密码加密
#然而我当时并不知道它使用的是base64加密（第一次的小白经历，谁都有的嘛~）
#然后就抓包测试了300来条数据进行测试，一开始一个字母一个字母试，然后总结规律
#发现了3位数据会生成4位密文，
#在此基础上，分析每一位密文的影响因素，然后发现ASCII码相邻的原始数据加密后有规律。
#第一版我采用了4张索引表，原始数据的第三位只影响密文第四位，原始数据第二位只影响密文第二和第三位，原始数据第一位只影响密文第一位
#勉强能用了，然后后面出bug了，我一看
#卧槽，在个别情况下，原始数据第二位会影响密文的一二三位，原始数据的第三位也会影响密文的第三四位
#然后我推翻了整个逻辑进行重新构思，我发现有一种类似进位的东西在里面
#最后我发现这是个64进制的进位，然后，只要用一张64进制的索引表进行进位就好了！
#然后就有了现在的第二版
#逆天，当我知道我这是base64，搜了一下base64的算法，发现是左移右移的知识和二进制运算，和我这个算法没有半毛钱关系。
#但我竟然用一种抽象的模式在10进制中还原了base64算法？？？
#这是高三写的大概是2022年11月份，因为怕删除这个美好的回忆，就保存在github上吧
#哈哈哈，我还挺牛逼的，其实我知道二进制和十进制也存在联系，但我还是觉得我很牛逼怎么办哈哈哈哈哈
