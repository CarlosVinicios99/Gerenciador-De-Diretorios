import Directory from "../models/Directory"

export default class DirectoriesService {

    private apiURL: string


    constructor(){
        this.apiURL = import.meta.env.VITE_API_URL || ""
    }


    async createDirectory(name: string, superDirectoryID: string): Promise<Directory> {
        try{
            const path: string = import.meta.env.VITE_API_PATH_DIRECTORIES || ""
            const urlService: string = `${this.apiURL}/${path}`

            const response: any = await fetch(urlService, {
                method: 'POST',
                body: JSON.stringify({
                    name,
                    superDirectoryID
                })
            })

            const directory: Directory = await response.json()

            return directory
        }
        catch(error){
            console.log(`erro ao criar novo diretório. Error: ${error}`)
            return {} as Directory
        }
    }

    async findRootDirectory(): Promise<Directory> {
        try{
            const path: string = 
                `${import.meta.env.VITE_API_PATH_DIRECTORIES}/${import.meta.env.VITE_API_PATH_ROOT}`
            const urlService: string = `${this.apiURL}/${path}`

            const response: any = await fetch(urlService, {
                method: 'GET'
            })

            const directory: Directory = await response.json()
            return directory
        }   
        catch(error){
            console.log(`erro ao buscar subdiretórios de um diretório. Error: ${error}`)
            return {} as Directory
        }    
    }

    async findDirectoryById(directoryId: string): Promise<Directory> {
        try{
            const path: string = `${import.meta.env.VITE_API_PATH_DIRECTORIES}/${directoryId}`
            const urlService: string = `${this.apiURL}/${path}`
            
            const response: any = await fetch(urlService, {
                method: 'GET'
            })

            const directory: Directory = await response.json()
            return directory
        }
        catch(error){
            console.log(`erro ao buscar diretório por ID. Error: ${error}`)
            return {} as Directory
        }
    }

    async findSubdirectoriesByDirectory(superDirectoryID: string): Promise<Directory[]> {
        try{
            const path: string = 
                `${import.meta.env.VITE_API_PATH_DIRECTORIES}/${superDirectoryID}/${import.meta.env.VITE_API_PATH_SUBDIRECTORIES}`
            const urlService: string = `${this.apiURL}/${path}`

            const response: any = await fetch(urlService, {
                method: 'GET'
            })

            const directories: Directory[] = await response.json()
            return directories
        }   
        catch(error){
            console.log(`erro ao buscar subdiretórios de um diretório. Error: ${error}`)
            return []
        }    
    }

}