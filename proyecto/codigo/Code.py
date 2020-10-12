import pandas as pd
import numpy as np
import random

def Average(dataset):
	
    sum_data = 0
    total = 0

    for value in range(0, len(dataset)):
        
        if dataset[value] == "": continue
        
        sum_data += int(dataset[value])
        total += 1

    return sum_data/total

#def Match():

def Gini():
	
    data = pd.read_csv('0_test_balanced_5000.csv', sep=";")

    gini = data[['estu_depto_reside.1', 'fami_estratovivienda.1', 'fami_pisoshogar', 'cole_naturaleza', 'cole_bilingue', 'cole_caracter',
    'cole_jornada', 'punt_lenguaje', 'punt_matematicas', 'punt_biologia', 'punt_quimica', 'punt_fisica', 'punt_ciencias_sociales', 'punt_filosofia', 'punt_ingles', 'desemp_ingles']]
    
    gini = gini.replace(np.nan, "", regex = True)

    themes = ['estu_depto_reside.1', 'fami_estratovivienda.1', 'fami_pisoshogar', 'cole_naturaleza', 'cole_bilingue', 'cole_caracter',
    'cole_jornada', 'punt_lenguaje', 'punt_matematicas', 'punt_biologia', 'punt_quimica', 'punt_fisica', 'punt_ciencias_sociales', 'punt_filosofia', 'punt_ingles', 'desemp_ingles']

    success = list(data['exito'])
    
    impurities = []
    blank = []

    col = 0
    
    for con_col in themes:
        
        data_col = list(gini[con_col])
        #data_col = gini[col]
        gini_si = 0
        gini_no = 0
        gini_blank = 0
        
        if col == 0:
        
            for row in range(0, len(data_col)):
                
                if data_col[row] == "":
                    gini_blank += 1
                elif data_col[row] == "BOGOTA" or row == "ANTIOQUIA":
                    if success[row] == 1: gini_si += 1
                    else: gini_no += 1
                elif data_col[row] != "BOGOTA" and row != "ANTIOQUIA":
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
        
        elif col == 1:
        
            for row in range(0, len(data_col)):
            
                if data_col[row] == "":
                    gini_blank += 1
                    continue
                
                strate = data_col[int(row)][8]
                
                if int(strate) >= 3:
                    if success[row] == 1: gini_si += 1
                    else: gini_no += 1
                else:
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
        
        elif col == 2:
        
            for row in range(0, len(data_col)):
            
                if data_col[row] == "":
                    gini_blank += 1
                elif data_col[row] == "Madera pulida, baldosa, tableta, mármol, alfombra":
                    if success[row] == 1: gini_si += 1
                    else: gini_no += 1
                elif data_col[row] == "Cemento, gravilla, ladrillo":
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
        
        elif col == 3:
        
            for row in range(0, len(data_col)):
            
                if data_col[row] == "":
                    gini_blank += 1
                elif data_col[row] == "NO OFICIAL":
                    if success[row]: gini_si += 1
                    else: gini_no += 1
                else:
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
            
        elif col == 4:
            
            for row in range(0, len(data_col)):
            
                if data_col[row] == "":
                    gini_blank += 1
                elif data_col[row] == "N" or row == "n":
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
                else:
                    if success[row] == 1: gini_si += 1
                    else: gini_no += 1
        
        elif col == 5:
            
            for row in range(0, len(data_col)):
            
                if data_col[row] == "":
                    gini_blank += 1
                elif data_col[row] == "ACADEMICO" or row == "ACADÉMICO":
                    if success[row] == 1: gini_si += 1
                    else: gini_no += 1
                else:
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
         
        elif col == 6:
            
            for row in range(0, len(data_col)):
                
                if data_col[row] == "":
                    gini_blank += 1
                elif data_col[row] == "MAÑANA":
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
                elif data_col[row] == "COMPLETA":
                    if success[row] == 1: gini_si += 1
                    else: gini_no += 1
             
        elif col >= 7 and col <= 14:
            
            for row in range(0, len(data_col)):
            
                aver = Average(data_col)
            
                if data_col[row] == "":
                    gini_blank += 1
                elif data_col[row] < aver:
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
                elif data_col[row] >= aver:
                    if success[row] == 1: gini_si += 1
                    else: gini_no += 1
                
        elif col == 15:
		
            for row in range(0, len(data_col)):
			
                if data_col[row] == "":
                    gini_blank += 1
                elif data_col[row] == "B1" or data_col[row] == "B+":
                    if success[row] == 1: gini_si += 1
                    else: gini_no += 1
                elif data_col[row] == "A-" or data_col[row] == "A1":
                    if success[row] == 0: gini_si += 1
                    else: gini_no += 1
                elif data_col[row] == "A2":
                    random_number = random.randint(0,1)
                    if random_number == 0:
                        if success[row] == 0: gini_si += 1
                        else: gini_no += 1
                    else:
                        if success[row] == 1: gini_si += 1
                        else: gini_no += 1
		
        imp = 1 - ((gini_si/(gini_si+gini_no))**2 + (gini_no/(gini_si+gini_no))**2)
        blank.append(gini_si + gini_no)
        impurities.append(imp)
        col += 1
    
    print(blank)
    return impurities
		
print(Gini())