import { shallowMount } from '@vue/test-utils';
import NoteInput from '@/components/NoteInput.vue';

describe('NoteInput', () => {
    it('loads a form element', () => {
        const wrapper = shallowMount(NoteInput);

        expect(wrapper.find('form').exists()).toBe(true);
    });

    it('contains a labelled text box for the title', () => {
        const wrapper = shallowMount(NoteInput);

        expect(wrapper.find('form #titleInputLabel').exists()).toBe(true);
        expect(wrapper.find('form #titleInput').exists()).toBe(true);
    });

    it('contains a labelled text box for the content', () => {
        const wrapper = shallowMount(NoteInput);

        expect(wrapper.find('form #contentInputLabel').exists()).toBe(true);
        expect(wrapper.find('form #contentInput').exists()).toBe(true);
    });

    it('contains a date box', () => {
        const wrapper = shallowMount(NoteInput);

        expect(wrapper.find('form #dateInputLabel').exists()).toBe(true);
        expect(wrapper.find('form #dateInput').exists()).toBe(true);
        expect(wrapper.find('form #dateInput').attributes().type).toEqual('date');
    })

    it('binds/models input boxes to data in component', () => {
        const wrapper = shallowMount(NoteInput);
        const title = wrapper.find('form #titleInput');
        const content = wrapper.find('form #contentInput');
        const date = wrapper.find('form #dateInput');
        
        title.setValue("jimmy");
        content.setValue("timmy");
        date.setValue("2018-07-22");
        
        expect(wrapper.vm.title).toBe("jimmy");
        expect(wrapper.vm.content).toBe("timmy");
        expect(wrapper.vm.date).toBe("2018-07-22");
    })

    it('shows todays date in the date field', () => {
        const wrapper = shallowMount(NoteInput);
        const today = new Date();
        const formattedDate = `${today.getFullYear()}-0${today.getMonth()+1}-${today.getDate()}`

        expect(wrapper.vm.date).toBe(formattedDate);
    })



});