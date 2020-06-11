package com.example.testing

fun initializeServerEntity(protocol:Byte,addressType:Byte,address:String,context_path:String,status:Byte) : ServerSettingEntity
{
return ServerSettingEntity(0,protocol,addressType,address,context_path,status )
}