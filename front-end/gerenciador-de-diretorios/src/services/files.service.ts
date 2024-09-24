import File from "../models/File"

export default class FilesService {

    private apiURL: string

    constructor(){
        this.apiURL = import.meta.env.VITE_API_URL || ""
    }
  
    async createFile(name: string, superDirectoryID: string): Promise<File> {
        try{
            const path: string = import.meta.env.VITE_API_PATH_FILES || ""
            const urlService: string = `${this.apiURL}/${path}`

            const response: any = await fetch(urlService, {
                method: 'POST',
                body: JSON.stringify({
                    name,
                    superDirectoryID
                })
            })

            const file: File = await response.json()
            return file
        }
        catch(error){
            console.log(`Erro ao criar arquivo. Error: ${error}`)
            return {} as File
        }
    }

    async findFilesByDirectoryId(directoryId: string): Promise<File[]> {
        try{
            const path: string = `${import.meta.env.VITE_API_PATH_FILES}/${import.meta.env.VITE_API_PATH_FILES_BY_DIRECTORY}`
            const urlService: string = `${this.apiURL}/${path}/${directoryId}`

            const response: any = await fetch(urlService, {
                method: 'GET'
            })

            const files: File[] = await response.json()
            return files
        }
        catch(error){
            console.log(`Erro ao buscar arquivos por diretório. Error: ${error}`)
            return []        
        }
    }

    async deleteFileById(fileId: string): Promise<void> {
        try{
            const path: string = import.meta.env.VITE_API_PATH_FILES || ""
            const urlService: string = `${this.apiURL}/${path}/${fileId}`
            console.log(urlService)

            await fetch(urlService, {
                method: 'DELETE'
            })
        }
        catch(error){
            console.log(`Erro ao deletar arquivo com ID ${fileId}. Error: ${error}`)
        }
    }

}