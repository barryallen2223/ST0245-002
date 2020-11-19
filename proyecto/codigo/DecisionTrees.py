import pandas as pd
import numpy as np
import array as arr
import random
from collections import deque
import time
import psutil
import pydoc


class ReadFile:

    """
    Clase utilizada para la lectura de archivos y su filtrado.
    """
    
    def __init__(self, *args):

        """
        Constructor que asigna el valor de la ruta y el signo separador del archivo csv.
        """

        if len(args) == 2:
            self.path = args[0]
            self.separator = args[1]
            self.read_file()
        
        elif len(args) == 1:
            self.dataset = args[0]
        
    
    def read_file(self):

        """
        Método que lee un archivo csv con la ruta indicada en los parámetros y retorna un dataframe filtrado.
        """

        # Separa y guarda en un frame la información del archivo.
        data = pd.read_csv(self.path, sep=self.separator)
        # Filtra los datos deseados.
        dataset = data[['estu_depto_reside.1', 'fami_pisoshogar', 'cole_naturaleza', 'punt_lenguaje', 'punt_matematicas', 'punt_biologia', 'punt_quimica', 'punt_fisica', 'punt_ciencias_sociales', 'punt_filosofia', 'desemp_ingles', 'exito']]
        
        dataset = dataset.replace(np.nan, "", regex = True)
        dataset = dataset.replace(np.nan, '', regex = True)
        dataset = dataset.replace(np.nan, " ", regex = True)

        self.dataset = dataset

pth = 'proof.csv'

"""
Dataset: Dataframe de los elementos leídos y globales.
Headers: Títulos de cada columna de Dataset.
"""

Dataset = ReadFile(pth, ";").dataset
Headers = list(Dataset)

def setDs(rf):
    
    """
    Permite cambiar la base de datos y el título de las columnas.
    rf: Nuevo readfile.
    """

    global Dataset
    Dataset = rf.dataset
    global Headers
    Headers = list(Dataset)


class Miscelaneous:

    """
    Utiliza métodos variados para que cualquier otra clase pueda acceder a ellos.
    """
    
    def fill_rows(self, start, end):

        """
        Toma los índices del dataset principal. Servirá para acoger el código a la partición/pérdida de algunos índices.
        start: Indice de inicio del llenado de la cola.
        end: Indice final del llenado de la cola
        """

        i_list = deque()

        for value in range(0, end - start):
            i_list.append(value + start)
        
        return i_list
    
    # Complejidad O(1).
    
    def is_numeric(self, value):

        """
        Pregunta si un valor que se le pasa es tipo numérico.
        :param value: Valor de comparación.
        """

        return isinstance(value, int) or isinstance(value, float)

    # Complejidad O(m).
    
    def find_average(self, data):

        """
        Encuentra el promedio de una cola.
        :param data: Elementos a promediar.
        """

        aver = 0

        for date in data:
            aver += date
        
        return aver / len(data)

    # Complejidad O(1).
    
    def match(self, possible_values, value):

        """
        Encuentra si dos valores son iguales o si uno contiene al otro.
        possible_values: Contenedor de los valores aceptados.
        value: Valor a buscar.
        """

        if self.is_numeric(value):
            if isinstance(possible_values, float) or isinstance(possible_values, int):
                return value >= possible_values
            else:
                return value >= possible_values[0]
        else:
            if isinstance(possible_values, str):
                return value == possible_values
            else:
                return self.contains(possible_values, value)

    # Complejidad O(m)
    
    def unique_values(self, dataframe, column):

        """
        Retorna los únicos posibles valores de una columna en un frame como lista.
        dataframe: Dataframe al que pertenece una columna a convertir.
        column: Columna a convertir.
        """

        return list(dataframe[Headers[column]].unique())

    # Para los usos que le damos a contains, es O(1), ya que el tamaño no es mayor a 5.
    
    def contains(self, dataset, value):

        """
        Busca si en una base de datos se encuentra el valor deseado.
        dataset: Base de datos en la que se busca.
        value: Valor a buscar.
        """

        for data in dataset:
            if data == value:
                return True
        
        return False

    # Complejidad O(m) [El tamaño de 15,7 nunca cambiará].
    
    def values_generator(self):

        """
        Genera los valores con los que se encontrará posteriormente la impureza de Gini.
        """

        values = [['BOGOTA', 'ANTIOQUIA', 'BOYACA'], ['Madera pulida, baldosa, tableta, mármol, alfombra'], ['ACADEMICO', 'TECNICO/ACADEMICO']]
        
      # for aver in range(7,15):
        for aver in range(3, 10):
            values.append([misc.find_average(Dataset[Headers[aver]])])

        values.append(['A2', 'B1', 'B+'])

        return values

    # Complejidad O(m*n). Con stack sería O(m).
    
    def split_matrix(self, dataset_indices, question):

        """
        Divide una cola en dos nuevas las cuales tendrán los datos que sean iguales a una condición deseada.
        dataset_indices: Cola a separar.
        question: Pregunta o decisión con la cual se separarán los datos.
        """

        if not isinstance(dataset_indices, deque):
            dataset_indices = dataset_indices.values.tolist()
        
        t_rows, f_rows = deque(), deque()

        for row in dataset_indices:
                if question.match(list(Dataset.loc[row])):
                    t_rows.append(row)
                else:
                    f_rows.append(row)
        
        return t_rows, f_rows

    # Complejidad O(1).
    
    def get_keys(self):

        """
        Devuelve todos los valores que se guardan en la generación de llaves del diccionario con las posibles colas a partir.
        """

        keys = []
        vals = self.values_generator()

        for v in vals:
            if not isinstance(v[0], float) and not isinstance(v[0], int):
                t = [[tuple(v)], ['Not In: ']]
                keys.append(t)

            else:
                t = [['Bigger than: ' + str(v[0])], ['Less than: ' + str(v[0])]]
                keys.append(t)

        return keys

    # Complejidad O(m*n), m número de elementos en el datatest y n número de variables.
    
    def successful(self, Dataset, tree, random):

        """
        Predice con respecto a unas condiciones si los elementos en una base de datos fueron bien elegidos o no.
        Dataset: Base de datos para la comparación.
        tree: Tiene las condiciones y las probabilidades de éxito.
        random: Método que se utilizará para escoger si un estudiante es exitoso o no.
        """

        suc = deque()

        for row in range(len(Dataset['exito'])):
            if random:
                self.rand_success(list(Dataset.loc[row]), tree, suc)
            else:
                self.not_rand_success(list(Dataset.loc[row]), tree, suc)
        
        return suc

    # Complejidad O(n), n número de variables.
    
    def rand_success(self, row, tree, success):

        """
        Auxiliar en el cual los éxitos son aleatorios dentro de un intervalo.
        row: Fila a la cual se le revisará si fue exitoso.
        tree: Árbol con las condiciones de predicción.
        success: Elementos ya conocidos sobre si un estudiante fue exitoso o no.
        """

        if isinstance(tree, Leaf):

            if random.random() <= tree.success:
                success.append(1)
            else:
                success.append(0)
            return
        
        if tree.question.match(row):
            self.rand_success(row, tree.true_branch, success)
        else:
            self.rand_success(row, tree.false_branch, success)

    # Complejidad O(n), n número de variables
    
    def not_rand_success(self, row, tree, success):

        """
        Auxiliar en el cual los éxitos son determinísticos por un índice.
        row: Fila a la cual se le revisará si fue exitoso.
        tree: Árbol con las condiciones de predicción.
        success: Elementos ya conocidos sobre si un estudiante fue exitoso o no.
        """

        if isinstance(tree, Leaf):
            if tree.success >= 0.5:
                success.append(1)
            else:
                success.append(0)
            return
        
        if tree.question.match(row):
            self.not_rand_success(row, tree.true_branch, success)
        else:
            self.not_rand_success(row, tree.false_branch, success)
            
    # Complejidad O(m), m número de datos en el testing.
    
    def exact_precis_sensib(self, threw_val, real_val):

        """
        Exactitud, Precisión y Sensibilidad del modelo.
        threw_val: Valores predichos por un árbol.
        real_val: Valores reales de un dataframe.
        """

        f_pos = 0
        f_neg = 0
        t_pos = 0
        t_neg = 0

        for ind in range(len(real_val)):
            if threw_val[ind] == real_val[ind]:

                if threw_val[ind] == 1:
                    t_pos += 1
                else:
                    t_neg += 1
            else:

                if threw_val[ind] == 1:
                    f_neg += 1
                else:
                    f_pos += 1
        
        return (t_pos + t_neg) / (t_pos + t_neg + f_pos + f_neg), t_pos / (t_pos + f_pos), t_pos / (t_pos + f_neg)
    
misc = Miscelaneous()

ValuesGen = misc.values_generator()

class Gini:

    """
    Generador de la impureza de Gini.
    """

    # Debido al cambio al método fill_rows, esto es actualmente una cola.
    
    def __init__(self):

        """
        Constructor.
        """

        self.rows_data = misc.fill_rows(0, len(Dataset[Headers[-1]]))

    # Complejidad O(m)
    
    def class_counts(self, *args):

        """
        Retorna en un diccionario todos los posibles valores a los que se puede llegar con respecto a unos datos y su frecuencia.
        """

        counts = {}
        possible_values = []

        if len(args) == 0:
            indices = self.rows_data
            column_to_work = list(Dataset[Headers[-1]])

        elif len(args) == 1:

            if isinstance(args[0], deque):
                indices = args[0]
                column_to_work = list(Dataset[Headers[-1]])

            elif isinstance(args[0], int):
                indices = self.rows_data
                column_to_work = Dataset[Headers[args[0]]]

        elif len(args) == 2:

            if isinstance(args[0], int):
                indices = self.rows_data
                column_to_work = Dataset[Headers[args[0]]]
                possible_values = args[1]
            
            if isinstance(args[1], int):
                indices = args[0]
                column_to_work = Dataset[Headers[args[1]]]

        elif len(args) == 3:
            indices = args[0]
            column_to_work = Dataset[Headers[args[1]]]
            possible_values = args[2]

        if len(possible_values) == 0:
            for row in indices:

                if column_to_work[row] not in counts:
                        counts[column_to_work[row]] = 0
                counts[column_to_work[row]] += 1
            
        else:

            if not isinstance(column_to_work[0], int) and not isinstance(column_to_work[0], float):
                keyError = tuple(possible_values)
                counts[keyError] = 0
                counts['Not In: '] = 0

                for row in indices:

                    where = misc.contains(possible_values, column_to_work[row])
                    
                    # if column_to_work[row] not in counts and not where:
                    #     counts[column_to_work[row]] = 0
                    
                    if where:
                        counts[keyError] += 1
                    else:
                        counts['Not In: '] += 1
            
            else:
                bt = "Bigger than: " + str(possible_values[0])
                lt = "Less than: " + str(possible_values[0])

                counts[bt] = 0
                counts[lt] = 0

                for row in indices:

                    if column_to_work[row] >= possible_values[0]:
                        counts[bt] += 1
                    else:
                        counts[lt] += 1

        return counts

    # Complejidad O(m)
    
    def find_gini(self, *args):

        """
        Encuentra la probabilidad de no clasificar correctamente a un estudiante. args[0]: Indices del dataset, args[1]: Posición del dataset, args[2]: Subconjunto del dataset aceptable.
        """

        if len(args) == 0:
            counts = self.class_counts()
            data = Dataset
        elif len(args) == 1:
            counts = self.class_counts(args[0])
            data = args[0]
        elif len(args) == 2:
            counts = self.class_counts(args[0], args[1])
            data = Dataset
        elif len(args) == 3:
            counts = self.class_counts(args[0], args[1], args[2])
            data = args[0]
        
        impurity = 1

        for label in counts:
            prob_of_label = counts[label] / float(len(data))
            impurity -= prob_of_label**2
        
        return impurity
    
    # Complejidad O(m).
    
    def info_gain(self, *args):

        """
        Define la ganancia de Gini.
        """

        prob = float(len(args[0])) / (len(args[0]) + len(args[1]))

        if len(args) == 3:
            return args[2] - prob * self.find_gini(args[0]) - (1 - prob) * self.find_gini(args[1])
        elif len(args) == 5:
            return args[2] - prob * self.find_gini(args[0], args[3], args[4]) - (1 - prob) * self.find_gini(args[1], args[3], args[4])
    
    
    def find_best_gini(self, *args):

        """
        Define la mejor variable a usar como condición.
        """

        if len(args) == 0:
            indices = self.rows_data
        elif len(args) == 1:
            indices = args[0]

        best_gini = 0.5
        best_question = None

        values = ValuesGen

        for column in range(len(Headers)-1):

            qs = Question(column, values[column])
            t_rows, f_rows = misc.split_matrix(self.rows_data, qs)
            t_rows, f_rows = self.fix_rows(t_rows, f_rows)

            # print(len(t_rows), len(f_rows))

            if len(t_rows) == 0 or len(f_rows) == 0:
                continue
                
            gini = self.find_gini(indices, column, values[column])
            # print(gini)

            if gini < best_gini:
                best_gini, best_question = gini, qs
        
        return best_gini, best_question
    
    # Complejidad O(m).
    
    def fix_rows(self, t_rows, f_rows):

        """
        Arregla la impureza en caso simple.
        """

        true_rows, false_rows = deque(), deque()

        for row in t_rows:
            if Dataset.at[row,'exito'] == 1:
                true_rows.append(row)
            else:
                false_rows.append(row)
        
        for row in f_rows:
            if Dataset.at[row,'exito'] == 0:
                true_rows.append(row)
            else:
                false_rows.append(row)
        
        return true_rows, false_rows
    
    # O(mn) Debido al uso de listas.
    
    def find_best_split(self, *args):

        """
        Encuentra la mejor forma de repartir la información.
        """

        if len(args) == 0:
            data = self.rows_data
        else:
            data = args[0]
        
        best_gain = 0
        best_question = None
        current_uncertainty = self.find_gini(data)
        n_features = len(Headers) - 1
        
        values = ValuesGen

        for column in range(n_features):

            qs = Question(column, values[column])
            true_rows, false_rows = misc.split_matrix(data, qs)
        
            if len(true_rows) == 0 or len(false_rows) == 0:
                continue
                
            gain = self.info_gain(true_rows, false_rows, current_uncertainty)

            if gain >= best_gain:
                best_gain, best_question = gain, qs
        
        return best_gain, best_question


class Question:

    """
    Define la mejor pregunta.
    """

    def __init__(self, *args):

        """
        Constructor. Acepta dos argumentos, los cuales son una pregunta y la columna en la cual se encuentra la pregunta.
        """

        if len(args) == 2:
            #column [numero]: Columna de la matriz con la que se trabaja.
            self.column = args[0]
            #value: Valor de la columna con la que se hará la pregunta.
            # Se debe aceptar que pueda ser un arreglo para el caso de string, así tener varias posibilidades. 
            self.value = args[1]
    
    # Complejidad O(1)
    def match(self, row_to_work):

        """
        Con respecto a una matriz, determina si el nuevo valor es igual al valor deseado.
        row_to_work: Fila con la cual se va a trabajar (La columna ya es conocida por el constructor).
        """

        the_value = row_to_work[self.column]
        if misc.is_numeric(the_value):
            if isinstance(self.value, float) or isinstance(self.value, int):
                return the_value >= self.value
            else:
                return the_value >= self.value[0]
        else:
            if isinstance(self.value, str):
                return the_value == self.value
            else:
                return misc.contains(self.value, the_value)
    
    
    def __repr__(self):

        """
        Imprime la pregunta.
        """
        
        condition = ">="
        if not misc.is_numeric(self.value):
            condition = "=="

        return "Is %s %s %s?" % (Headers[self.column], condition, str(self.value))


class Leaf:

    """
    Define la predicción de éxito.
    """

    def __init__(self, positions_of_a_dataset, question):

        """
        Guarda la cantidad de personas que pasaron y las que no.
        """

        gn = Gini()
        self.predictions = gn.class_counts(positions_of_a_dataset)

        if len(self.predictions.values()) == 2:
            self.success = float(self.predictions.get(1)) / float(self.predictions.get(0) + self.predictions.get(1))
          # print(self.success)
        else:
            if list(self.predictions.keys()) == [0]:
                self.success = 0
            elif list(self.predictions.keys()) == [1]:
                self.success = 1


class Node:

    """
    Define los nodos de decisión.
    Nodo de decisión: Está hecho para guardar solamente una pregunta y los hijos.
    """

    def __init__(self, question, true_branch, false_branch):

        """
        Constructor.
        question: Pregunta con la cual se generará la condición.
        true_branch: Datos que cumplen con la condición.
        false_branch: Datos que no cumplen con la condición.
        """

        self.question, self.true_branch, self.false_branch = question, true_branch, false_branch


class Tree:

    """
    Generador de árbol.
    """

    def __init__(self, height):

        """
        Constructor.
        height: Altura máxima del árbol.
        """

        self.current = Node
        self.height = height
        
    def Tree(self, indices):

        """
        Crea el árbol.
        indices: Filas iniciales del árbol.
        """

        limit = self.height
        return self.auxTree(indices, limit)

    def auxTree(self, indices, limit):

        """
        Auxiliar de la creación del árbol.
        indices: Filas actuales del nodo.
        limit: Altura máxima.
        """

        gn = Gini()

        Gain, qs = gn.find_best_split(indices)

        if Gain == 0:
            return Leaf(indices, qs)

        if limit != 0:
            true_rows, false_rows = misc.split_matrix(indices, qs)

            # Ramas del árbol.
            true_branch = self.auxTree(true_rows, limit-1)
            false_branch = self.auxTree(false_rows, limit-1)
        else:
            # Hojas finales con los resultados del árbol.
            return Leaf(indices, qs)

        return Node(qs, true_branch, false_branch)
    
    #El nodo inicial es el árbol que se crea a través de la fn. Tree.
    def TreeToList(self, node):

        """
        Toma un árbol o nodo inicial para generar una matriz con sus datos.
        node: Árbol o nodo inicial.
        """

        list_nodes = []
        return self.auxTTL(node, list_nodes)

    def auxTTL(self, node, list_nodes):

        """
        Auxiliar de TreeToList.
        node: Nodo inicial.
        list_nodes: Lista con todos los nodos de un árbol.
        """

        if isinstance(node, Leaf):
            list_nodes.append(node)
            return
        
        self.auxTTL(node.false_branch, list_nodes)
        self.auxTTL(node.true_branch, list_nodes)
        
        return list_nodes
    
    # def getAlgorithmSuccess(self, list_nodes):
        
    #     success = 0
    #     fail = 0

    #     for dictionary in list_nodes:
    #         d_val = list(dictionary.predictions.values())

    #         if len(d_val) == 1:
    #             success += d_val[0]
    #             continue

    #         if d_val[0] >= d_val[1]:
    #             success += d_val[0]
    #             fail += d_val[1]
    #         else:
    #             success += d_val[1]
    #             fail += d_val[0]
        
    #     return success / (fail + success), fail / (fail + success)

    def print_tree(self, node, spacing=""):

        """
        Imprime un árbol.
        node: Nodo inicial.
        """

        # Base case: we've reached a leaf
        if isinstance(node, Leaf):
            print ("Predict", node.predictions)
            return

        # Print the question at this node
        print (str(node.question))
        print ('--> if True:')
        self.print_tree(node.true_branch, spacing + "  ")
        print ('--> if False:')
        self.print_tree(node.false_branch, spacing + "  ")

    # def save_tree(self, node):

    #     toprint = []

    #     list_of_nodes = deque()
    #     list_of_nodes = self.aux_save_tree(node, list_of_nodes)

    #     for nod in list_of_nodes:

    #         if isinstance(nod, Leaf):
    #             toprint.append(nod.success)
    #         else:
    #             t = str(nod.question.column) + ":" + str(nod.question.value)
    #             toprint.append(t)
        
    #     f = open('t1.txt', 'wb')
    #     for i in range(len(toprint)):
    #         if isinstance(toprint[i], float) or isinstance(toprint[i], int):
    #             f.write("%1.4f\n" % (toprint[i]))
    #         else:
    #             f.write("%s\n" % (' '.join(format(ord(x), 'b') for x in toprint[i])))
    #     f.close()

    # def aux_save_tree(self, node, list_of_nodes):

    #     list_of_nodes.append(node)

    #     if isinstance(node, Leaf):
    #         return
    #     else:
    #         self.aux_save_tree(node.false_branch, list_of_nodes)
    #         self.aux_save_tree(node.true_branch, list_of_nodes)
        
    #     return list_of_nodes


class BackTesting:

    """
    Crea el dataframe necesario para probar un árbol.
    """

    def __init__(self, path, train_tree):

        """
        Constructor para la creación del dataframe.
        path: Lugar del computador en el que están los datos.
        train_tree: Árbol de entrenamiento.
        """

        rf = ReadFile(path, ";")
        self.dataset_to_prove = rf.dataset
        self.train_tree = train_tree
        self.success = list(self.dataset_to_prove[Headers[-1]])
    

def main():

    train_files = ['/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/0_train_balanced_15000.csv', '/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/1_train_balanced_45000.csv', '/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/2_train_balanced_75000.csv', '/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/3_train_balanced_105000.csv', '/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/4_train_balanced_135000.csv']

    # test_files = ['/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/0_test_balanced_5000.csv', '/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/1_test_balanced_15000.csv', '/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/2_test_balanced_25000.csv', '/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/3_test_balanced_35000.csv', '/home/salvarezo1/Documents/Documentos Universidad/Semestre 2/Estructura Datos y Algoritmos 1/Proyecto Final/Código 2/4_test_balanced_45000.csv']

    for pos in range(len(train_files)):

        rfTr = ReadFile(train_files[pos], ";")
        setDs(rfTr)
        t = Tree(6)
        gn = Gini()
        this_tree = t.Tree(gn.rows_data)
        #t.print_tree(this_tree)

        times = []

        # Train Code testing

        #START
        print('START TESTTRAIN OF DATASET:', len(Dataset))
        aver_exact, aver_prec, aver_sens = 0, 0, 0

        for _ in range(20):
            success_train = misc.successful(Dataset, this_tree, True)
            exact, prec, sens = misc.exact_precis_sensib(success_train, Dataset[Headers[-1]])
            aver_exact += exact
            aver_prec += prec
            aver_sens += sens
        
        print("Average exaction:", aver_exact/20)
        print("Average precision:", aver_prec/20)
        print("Average sensibility:", aver_sens/20)

        print('______________________')
        print("Not suppose randoms:")
        print('Average in order:', misc.exact_precis_sensib(misc.successful(Dataset, this_tree, False), Dataset[Headers[-1]]))
        print('______________________')
        print('Memory Usage:', psutil.virtual_memory())
        # print('Memory Heap:', h.heap())
        print('______________________')
        print('END TESTTRAIN OF DATASET:', len(Dataset))
        #END
        print('__________________________')
        # Test Code

        print('START TEST OF DATASET:', pos)
        # for test in range(3):

        #     tm = time.time()
        #     bt = BackTesting(test_files[pos], this_tree)
            #print(len(bt.dataset_to_prove))

            # aver_exact, aver_prec, aver_sens = 0, 0, 0

            # for _ in range(20):
            #     success_test = misc.successful(bt.dataset_to_prove, this_tree, True)
            #     exact, prec, sens = misc.exact_precis_sensib(success_test, bt.dataset_to_prove[Headers[-1]])
            #     aver_exact += exact
            #     aver_prec += prec
            #     aver_sens += sens
            
            # print("Average exaction:", aver_exact/20)
            # print("Average precision:", aver_prec/20)
            # print("Average sensibility:", aver_sens/20)

            # print('______________________')
            # print("Not suppose randoms:")
            # print('Average in order:', misc.exact_precis_sensib(misc.successful(Dataset, this_tree, False), Dataset[Headers[-1]]))
            # tmf = time.time()

            # times.append(tmf-tm)
            # print('________________________ END', test, '_______________________')
        
        c = 1
        print('Times of execution of testing')
        print('_____________________________')
        for t in times:
            print(c, t)
        print('_____________________________')
        
        print('END TEST OF DATASET', pos)
        print('__________________________________________________________________')
        print('__________________________________________________________________')
    
if __name__=='__main__':
    main()