class selfExample:
    def className (self,name):
        self.name = "self" + name 
        print("self : "+self.name + " param : "+name)

a = selfExample()
a.className("철수")