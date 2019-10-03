#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Jul 25 16:42:47 2019

@author: shashanknigam
"""

#Final Program:

#Library for reading Pdf files: 
import PyPDF2 as pdf
#for web page hitting
from selenium import webdriver
#for web scrapping
from bs4 import BeautifulSoup as s
#for converting the data as data frame
import pandas as pd
 
import re
uris=[] #used for storing the url extracted
courseName=[]
courseDuration=[]
referenceNo=[]
courseTime=[]
coursePartOf=[]
courseIntroduction=[]
courseClasses=[]
courseDates=[]
courseTakeAways=[]
courseAttendes=[]
courseTopicsCovered=[]
courseSsip_t=[]
courseSspr_t=[]
courseSssfmces_t=[]
courseSswfts_t=[]
courseSsip_c=[]
courseSspr_c=[]
courseSssfmces_c=[]
courseSswfts_c=[]
courseCsip_t=[]
courseCspr_t=[]
courseCssfmces_t=[]
courseCswfts_t=[]
courseCsip_c=[]
courseCspr_c=[]
courseCssfmces_c=[]
courseCswfts_c=[]
courseExamS=[]
courseExamC=[]

courseParent=[]



#Part 1: Reading the pdf file and generating the list of urls from the same
pdfFileobj = open('/Users/shashanknigam/downloads/nus-iss-executive-education-planner-2019.pdf','rb')
pdfReader = pdf.PdfFileReader(pdfFileobj)

def web_browser(web):
    if web.find("exam-only")==-1:
        print(web+" done!")
        browser = webdriver.Safari() #choosing safari as default others can be used
        browser.get(web)
        content = browser.page_source
        browser.close()
        return content
    else:
        print(web)
        print("Ignoring the site at the moment")
     #returns the web soruce

def find_next_sibling(tag):
    sib = tag
    if tag.next_sibling.string =='\n':
        sib = tag.next_sibling.next_sibling
    else:
        sib = tag.next_sibling
    return sib

def get_tag_string(tag):
    return tag.getText().replace('\n','').strip()

def get_amount_course(tag):
    amount=[]
    for i in range(4):
        tag = find_next_sibling(tag)
        amount.append(get_tag_string(tag))
    return amount 

def get_parent_td(tag):
    while tag.name!='td':
        tag = tag.parent
    return tag

def get_exam_fee(tag):
    amount = None
    for i in tag.descendants:
        r = re.search("Total fee",str(i.string))
        if r is not None:
            amount = i
    if amount is not None:
        amount =get_parent_td(amount)
        amount=find_next_sibling(amount)
        return get_tag_string(amount)
    else:
        print("Error!!!!!!!!!!!!!!")

def get_Aop_fee(tag):
    amount = None
    for i  in tag.descendants:
        r = re.search("AOP fee",str(i.string))
        if r is not None:
            amount=i
    if amount is not None:
         amount=get_parent_td(amount)
         return get_tag_string(amount)
    else:
         print("Tag does not contain any values")

def get_simple_cfee(tag):
    w=None
    for i in tag.descendants:
        r=re.search("Total nett",str(i.string))
        if r is not None:
            w=i
    if w is not None: 
        tag=get_parent_td(w)  
        amount=[0,0,'N/A','N/A']
        for i in range(2):
            tag = find_next_sibling(tag)
            amount[i]=get_tag_string(tag)
        return amount
    else:
        print("Not found")
        return [0,0,0,0]




def web_parser(websource):
    exam_fee_s=''
    exam_fee_c=''
    amount_st=[0,0,0,0]
    amount_sc=[0,0,0,0]
    amount_ct=[0,0,0,0]
    amount_cc=[0,0,0,0]
    soup=s(websource,'html.parser')
    contentTitle=soup.find('h1',id="hdrTitle").text.strip()
    table=soup.find('div',id="overview")
    t = table.text.replace('\n','').split('      ')
    t1=''
    for i in range(len(t)):
        if t[i].strip()!='':
            t1=t1 +" "+t[i].strip()
    reference_no=t1[(t1.find("Reference No")+len("Reference No")):(t1.find("Part of"))].strip()
    partOf=t1[(t1.find("Part of")+len("Part of")):(t1.find("Duration"))].strip()
    duration=t1[(t1.find("Duration")+len("Duration")):(t1.find("Course Time"))].strip()
    if t1.find("pm")!='-1':
        CourseTime=t1[(t1.find("Course Time")+len("Course Time")):(t1.find("pm")+len("pm"))].strip()
    else:
        CourseTime=t1[(t1.find("Course Time")+len("Course Time")):(t1.find("PDU"))].strip()
    courseIntro=t1[(t1.find("details.")+len("details.")):].strip()
    classes= soup.find_all('span',{'class':'accordion_header-class'})
    class_dates = soup.find_all('span',{'class':'accordion_header-date'})
    for i in range(len(classes)):
        classes[i] = classes[i].text
    for i in range(len(class_dates)):
        class_dates[i] = class_dates[i].text.strip().replace('\n',' ')
    tag = soup.find('div',{'class':'main-content-entry','id':'tab1'})
    keyTakeAways = tag.getText().replace('\n','').strip().replace(tag.find('h2').getText(),'')
    tag = soup.find('div',{'class':'main-content-entry','id':'tab2'})    
    whoShouldAttend = tag.getText().replace('\n','').strip().replace(tag.find('h2').getText(),'')
    tag = soup.find('div',{'class':'main-content-entry','id':'tab3'})
    if tag.getText().find("Fees & Funding")!='-1' and len(tag.find_all('table'))!=0:
        topicsCovered = ''
        table = tag.find_all('table')
    else:
        topicsCovered=tag.getText().replace('\n','').strip().replace(tag.find('h2').getText(),'')
        topicsCovered = tag.getText().replace('\n','').strip().replace(tag.find('h2').getText(),'')
        tag = soup.find('div',{'class':'main-content-entry','id':'tab4'})
        table = tag.find_all('table')
    
    #Length of the tables can be 2 or more 
    
    l = len(table)
    print(l)
    dimc=0
    if l==2:
        
        w = None
        rows=table[0].find_all('tr')
        data = []
        dimc = len(rows)
        for i in rows:
            cols=i.find_all('td')
            data.append(cols)
        dimc = len(data[0])    
        
        if dimc == 3:
            amount_st=get_simple_cfee(table[0])
            amount_sc = amount_st
            exam_fee_s=get_exam_fee(table[1])
            exam_fee_c = exam_fee_s
            amount_ct = ['N/A','N/A','N/A','N/A']
            amount_cc=amount_ct
            
        else:
            for i in table[0].descendants:
                r = re.search("Total nett course fee payable,",str(i.string))
                if r is not None:
                    w= i
                    break
            if w is not None:    
                w = get_parent_td(w)
                amount_st=get_amount_course(w)
            else:
                amount_st=[0,0,0,0]
        
            w = None    
            for i in table[0].descendants:
                r = re.search("Total nett course fee payable,",str(i.string))
                if r is not None:
                    w=i
            if w is not None:        
                w = get_parent_td(w)
                amount_sc = get_amount_course(w)
            else:
                amount_sc=amount_st
            
            w = None
            for i in table[1].descendants:
                r = re.search("Total nett course fee payable,",str(i.string))
                if r is not None:
                    w=i
                    break
            if w is not None:        
                w = get_parent_td(w)
                amount_ct = get_amount_course(w)
            else:
                amount_ct=[0,0,0,0]
        
            w = None
            for i in table[1].descendants:
                r=re.search('from the various funding schemes',str(i.string))
                if r is not None:
                    w=i
                    break
            if w is not None:
                w=get_parent_td(w)
                amount_cc = get_amount_course(w)
                for i in range(4):
                    if amount_cc[i]=='-':
                        amount_cc[i]=amount_ct[i]
            
            else:
                amount_cc= amount_ct
             
    elif l==4:
        print("I am here")
        w = None
        for i in table[0].descendants:
            r = re.search("Total nett course fee payable,",str(i.string))
            if r is not None:
                w= i
                break
        if w is not None:    
            w = get_parent_td(w)
            amount_st=get_amount_course(w)
        else:
            amount_st=[0,0,0,0]
        
        w = None    
        for i in table[0].descendants:
            r = re.search("Total nett course fee payable,",str(i.string))
            if r is not None:
                w=i
                
        if w is not None:        
            w = get_parent_td(w)
            amount_sc = get_amount_course(w)
        else:
            amount_sc=amount_st
            
        w = None
        for i in table[2].descendants:
            r = re.search("Total nett course fee payable,",str(i.string))
            if r is not None:
                w=i
                break
        if w is not None:        
            w = get_parent_td(w)
            amount_ct = get_amount_course(w)
        else:
            amount_ct=[0,0,0,0]
        
        w = None
        for i in table[2].descendants:
            r=re.search('from the various funding schemes',str(i.string))
            if r is not None:
                w=i
                break
        if w is not None:
            w=get_parent_td(w)
            amount_cc = get_amount_course(w)
            for i in range(4):
                if amount_cc[i]=='-':
                    amount_cc[i]=amount_ct[i]
            
        else:
             amount_cc= amount_ct
        exam_fee_s=get_exam_fee(table[1])
        exam_fee_c=get_exam_fee(table[3])
    elif l==1:
         exam_fee_s=get_Aop_fee(table[0])       
    print(amount_st)             
    parent=''
    tag = soup.find_all('div',{'class':'block-accordion-courses--header'})
    for i in tag:
        if parent=='':
            parent=i.string
        else:
            parent= parent +", "+i.string
    for i in range(len(classes)):        
        courseName.append(contentTitle)
        referenceNo.append(reference_no)
        coursePartOf.append(partOf)
        courseDuration.append(duration)
        courseTime.append(CourseTime)
        courseIntroduction.append(courseIntro)
        courseClasses.append(classes[i])
        courseDates.append(class_dates[i])
        courseTakeAways.append(keyTakeAways)
        courseAttendes.append(whoShouldAttend)
        courseTopicsCovered.append(topicsCovered)
        courseSsip_t.append(amount_st[0])
        courseSspr_t.append(amount_st[1])
        courseSssfmces_t.append(amount_st[2])
        courseSswfts_t.append(amount_st[3])
        courseSsip_c.append(amount_sc[0])
        courseSspr_c.append(amount_st[1])
        courseSssfmces_c.append(amount_st[2])
        courseSswfts_c.append(amount_st[3])
        courseCsip_t.append(amount_ct[0])
        courseCspr_t.append(amount_ct[1])
        courseCssfmces_t.append(amount_ct[2])
        courseCswfts_t.append(amount_ct[3])
        courseCsip_c.append(amount_cc[0])
        courseCspr_c.append(amount_cc[1])
        courseCssfmces_c.append(amount_cc[2])
        courseCswfts_c.append(amount_cc[3])
        courseExamS.append(exam_fee_s)
        courseExamC.append(exam_fee_c)
        courseParent.append(parent)
   
#Reading the number of pages 
nums=pdfReader.numPages #7 pages
for i in range(nums):
    #Reading the page 
    pageObj= pdfReader.getPage(i)#It takes the page number as the module and returns the page object. 
    key = "/Annots"
    uri = "/URI"
    ank = "/A"
    #Getting page objects
    pageObject=pageObj.getObject()
    #Getting the list of Urls defined under /Annots
    ann =pageObject["/Annots"]
    for a in ann:
        u = a.getObject()
        if '/A' in u.keys():
            u = u['/A']
            if '/URI' in u.keys():
                if u['/URI'] !='https://www.iss.nus.edu.sg/' and u['/URI']!= 'mailto:isstraining@nus.edu.sg' and  u['/URI'] not in u:
                    uris.append(u['/URI'])
        

#uri's contain all the information
                    
for i in uris:
    webpage=web_browser(i)
    if webpage is not None:
        web_parser(webpage)
    #Parsing the web page
                       

#creating a data frame from the data parsed:
    
df = pd.DataFrame({
        'Parent Courses':courseParent,
        'Name':courseName,
        "Reference":referenceNo,
        "Part Of":coursePartOf,
        'Duration':courseDuration,
        'Time':courseTime,
        'Introduction':courseIntroduction,
        'Classes':courseClasses,
        'Dates':courseDates,
        'Take Away':courseTakeAways,
        'Prequisite/Requirement':courseAttendes,
        'Topic Covered':courseTopicsCovered,
        'Self Funded International Participants(Net)': courseSsip_t,
        'Self Funded Pr/Singaporean(Net)':courseSspr_t,
        'Self Funded with SkillsFuture Mid-Career Enhanced Subsidy(Net)':courseSssfmces_t,
        'Self Funded Workfare Training Support(Net)':courseSswfts_t,        
        'Self Funded International Participants(Concession)': courseSsip_c,
        'Self Funded Pr/Singaporean(Concession)':courseSspr_c,
        'Self Funded with SkillsFuture Mid-Career Enhanced Subsidy(Concession)':courseSssfmces_c,
        'Self Funded Workfare Training Support(Concession)':courseSswfts_c,        
        'Company Sponsered International Participants(Net)': courseCsip_t,
        'Company Sponsered Pr/Singaporean(Net)':courseCspr_t,
        'Company Sponsered with SkillsFuture Mid-Career Enhanced Subsidy(Net)':courseCssfmces_t,
        'Company Sponsered Workfare Training Support(Net)':courseCswfts_t,        
        'Company Sponsered International Participants(Concession)': courseCsip_c,
        'Company Sponsered Pr/Singaporean(Concession)':courseCspr_c,
        'Company Sponsered with SkillsFuture Mid-Career Enhanced Subsidy(Concession)':courseCssfmces_c,
        'Company Sponsered Workfare Training Support(Concession)':courseCswfts_c,
        'Exam Fee Self':courseExamS,
        'Exam Fee Company(Sponsered)':courseExamC
                
        })

#Writing the data frame to excel

df.to_excel('/Users/shashanknigam/downloads/data.xls')    


