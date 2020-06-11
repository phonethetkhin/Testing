package com.example.testing

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ServerSettingViewModel(application: Application) : AndroidViewModel(application) {
    private val serverSettingDao = FamsAppDatabase.getFAMSDB(application)!!.serverSettingDao()
    private val serverSettingRepo = SeverSettingRepo(serverSettingDao)
    val serverSettingLiveData = serverSettingRepo.serverSettingLiveData


    val serverSettingLiveDataList = serverSettingRepo.serverSettingLiveDataList

    fun getAllServerSetting() = viewModelScope.launch {
        serverSettingRepo.getAllServerSetting()
    }


    fun insertServerSetting(serverSettingEntity: ServerSettingEntity) = viewModelScope.launch {
        serverSettingRepo.insertServerSetting(serverSettingEntity)
    }

    fun updateServerSetting(serverSettingEntity: ServerSettingEntity) = viewModelScope.launch {
        serverSettingRepo.updateServerSetting(serverSettingEntity)
    }

    fun deleteServerSetting(serverSettingEntity: ServerSettingEntity) = viewModelScope.launch {
        serverSettingRepo.deleteServerSetting(serverSettingEntity)
    }

    fun deleteAllServerSetting() = viewModelScope.launch {
        serverSettingRepo.deleteAllServerSetting()
    }

    fun getServerSetting(id: Int) : List<ServerSettingEntity> {
        return serverSettingRepo.getServerSetting(id)
    }

}