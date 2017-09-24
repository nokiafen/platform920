package com.comba.android.combacommon.contacts;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.comba.android.combacommon.R;
import com.comba.android.combacommon.adapters.OnItemClickListener;
import com.comba.android.combacommon.adapters.RecyclerListSingleAdapter;
import com.comba.android.combacommon.net.BaseOkHttpActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by chenhailin on 2017/6/1.
 */

public class ContactRecordListActivity extends BaseOkHttpActivity {

    public List<Contact> contacts;
    private List<String> imageItems;
    private ContactsOperationUtil opUtil;

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_https);
        imageItems = Arrays.asList(getResources().getStringArray(R.array.activity_dialog_item));
        RecyclerListSingleAdapter listAdapter = new RecyclerListSingleAdapter(imageItems, mItemClickListener);
        RecyclerView recyclerView = ButterKnife.findById(this, R.id.rv_https_activity);
        recyclerView.setAdapter(listAdapter);
        opUtil = new ContactsOperationUtil(this);
    }


    private OnItemClickListener mItemClickListener = new OnItemClickListener() {


        @Override
        public void onItemClick(View v, int position) {
            if (0 == position) {
           contacts= opUtil.getAllContacts();
                android.widget.Toast.makeText(ContactRecordListActivity.this,"查询到"+contacts.size()+"条联系人", android.widget.Toast.LENGTH_SHORT).show();
            } else if(1==position){
                if(contacts==null||contacts.size()==0){
                    android.widget.Toast.makeText(ContactRecordListActivity.this,"请先查询", android.widget.Toast.LENGTH_SHORT).show();
                    return;
                }
                contacts.remove(contacts.get(0));
                opUtil.deleteContacts(contacts);
            }else if(2==position){
                List<Contact> contacts=new ArrayList<>();
                Contact cat=new Contact();
                cat.setName("cat");
                cat.setPhoneNUm("4586123452");
                contacts.add(cat);
                Contact cat1=new Contact();
                cat1.setName("cat1");
                cat1.setPhoneNUm("45861234521");
                contacts.add(cat1);
                opUtil.insertContacts(contacts);
                android.widget.Toast.makeText(ContactRecordListActivity.this,"已插入联系人cat1", android.widget.Toast.LENGTH_SHORT).show();
            }else if(3==position){
                if(contacts==null||contacts.size()==0){
                    android.widget.Toast.makeText(ContactRecordListActivity.this,"请先查询", android.widget.Toast.LENGTH_SHORT).show();
                    return;
                }
               Contact contact= contacts.get(0);
                contact.setName("changen");
                List<Contact> contacts=new ArrayList<>();
                contacts.add(contact);
             opUtil.updateContactsIps(contacts);
                android.widget.Toast.makeText(ContactRecordListActivity.this,"已更新联系人"+contact.getName(), android.widget.Toast.LENGTH_SHORT).show();
            }
        }
    };



}
