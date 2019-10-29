# URL示例

## /login/in POST

用于登陆。

Request body

    name
    passwd
    
返回值

    
    exist : 用户名是否存在
    ok : 密码是否正确
    token : token的值

## /userinfor/infor GET

用于获取用户信息。
需要在header中加入token。

返回示例

    {
        "username": "Hahi",
        "img": null,
        "gender": "男",
        "idtype": "shenfenzheng",
        "idnumber": "23333333333",
        "nation": "china",
        "area": "upcupc",
        "address": "chinaupc"
    }


## /userinfor/update/name

更新用户名。
参数
    name : 新用户名

返回值为true/false。

## /userinfor/update/canumber

更新商户证书号码。
参数
    canumber : 新号码
    
返回值为true/false。

## /market GET

用于返回所有市场的信息。

返回值

    keyid : 市场id
    name : 市场名称
    x : 市场位置x坐标
    y : 市场位置y坐标
    location : 市场位置描述

返回示例

    [
        {
            "keyid": 1,
            "name": "中国石油大学华东",
            "x": 120.175959,
            "y": 35.943478,
            "location": "长江西路"
        },
        {
            "keyid": 2,
            "name": "Rome",
            "x": 2,
            "y": 2,
            "location": "Europe"
        }
    ]



## /notification/getall GET

用于返回所有通知信息。

返回示例

    [
        {
            "keyid": 1,
            "content": "下雨天，睡觉天",
            "author": "mhr",
            "time": "2019-05-23T02:25:58.000+0000",
            "title": "下雨"
        },
        {
            "keyid": 2,
            "content": "下雨下雨",
            "author": "aa",
            "time": "2019-05-23T03:35:42.000+0000",
            "title": "下雨了"
        }
    ]

## /notification/getbyid GET

返回指定id的通知信息。
如果id不存在，返回空值。

参数
    id : 要返回的通知信息的id。

返回示例

    {
        "keyid": 1,
        "content": "下雨天，睡觉天",
        "author": "mhr",
        "time": "2019-05-23T02:25:58.000+0000",
        "title": "下雨"
    }



## /stall/listquery GET

返回指定市场的所有摊位信息。

参数
    id : 要查询的摊位所属市场的id。
    
返回示例

    {
        "currentlist": [
            {
                "keyid": 1,
                "nodeX": 1,
                "nodeY": 1,
                "marketBelong": 1,
                "occupying": false
            },
            {
                "keyid": 2,
                "nodeX": 2,
                "nodeY": 2,
                "marketBelong": 1,
                "occupying": false
            }
        ]
    }
    

## /stall/idquery

按照摊位id查询查询摊位信息。

参数

    id : 要查询的摊位的id

返回示例

    {
        "stall": {
            "keyid": 1,
            "nodeX": 1,
            "nodeY": 1,
            "marketBelong": 1,
            "occupying": false
        }
    }
    
    
## /tenant/phonequery GET

查询商户信息。

参数

    id : 
    
返回示例
    
    
## /recomend GET

返回主页推荐商品信息。


## /uploadfile/{filename} POST
根据登陆后的信息，上传文件名为filename的资源，返回访问资源的地址。
注意文件扩展名。

headers
    
    token : 登陆获取的token
    
返回示例

    {
        "success": "/res/50/123.png"
    }

    {
        "fail": "fail"
    }
    

## /uploadpubfile/{filename} POST
上传公共资源，用法同上。用于辅助开发的临时功能。

返回示例

    {
        "success": "/pubres/123.png"
    }

    {
        "fail": "fail"
    }
    
    
## (resroot)/{filename} GET
用于访问uploadfile上传的特定用户专有的资源。
resroot是登陆时返回的字符串，结构为"/res/{id}/"。

## /pubres/{filename} GET
用于访问uploadpubfile上传的公共资源。

## /uploaddefaultfile/{filename} POST (未完成)
用于上传特定用户专有的资源的默认资源文件。当用户没有上传时，访问(resroot)/{filename}将返回同名的默认文件。